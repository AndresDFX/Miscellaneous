package com.example.flightreservation.service;

import com.example.flightreservation.exception.ReservationNotFoundException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.model.Reservation;
import com.example.flightreservation.model.ReservationStatus;
import com.example.flightreservation.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private FlightService flightService;

    @Mock
    private KafkaProducerService kafkaProducerService;

    @InjectMocks
    private ReservationService reservationService;

    private Flight flight;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        flight = new Flight("AB123", 10);
    }

    @Test
    public void testCreateReservation_Success() {
        when(flightService.getFlightByNumber("AB123")).thenReturn(Optional.of(flight));
        when(flightService.reserveSeat(flight.getId())).thenReturn(flight);
        Reservation reservation = new Reservation(flight, "1A", ReservationStatus.CONFIRMED);
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Reservation created = reservationService.createReservation("AB123", "1A");
        assertThat(created.getSeatNumber()).isEqualTo("1A");
        assertThat(created.getStatus()).isEqualTo(ReservationStatus.CONFIRMED);
        verify(kafkaProducerService, times(1)).sendReservationEvent(anyString());
    }

    @Test
    public void testCancelReservation_Success() {
        Reservation reservation = new Reservation(flight, "1A", ReservationStatus.CONFIRMED);
        when(reservationRepository.findById(1L)).thenReturn(Optional.of(reservation));
        when(flightService.cancelSeat(flight.getId())).thenReturn(flight);
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);

        Reservation cancelled = reservationService.cancelReservation(1L);
        assertThat(cancelled.getStatus()).isEqualTo(ReservationStatus.CANCELED);
    }

    @Test
    public void testCancelReservation_NotFound() {
        when(reservationRepository.findById(1L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> reservationService.cancelReservation(1L))
            .isInstanceOf(ReservationNotFoundException.class);
    }
}
