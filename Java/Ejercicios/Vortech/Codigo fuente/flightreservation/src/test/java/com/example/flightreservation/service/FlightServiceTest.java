package com.example.flightreservation.service;

import com.example.flightreservation.exception.SeatNotAvailableException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    private Flight flight;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        flight = new Flight("AB123", 10);
        // Asigna manualmente un ID para que los tests puedan buscar el vuelo.
        ReflectionTestUtils.setField(flight, "id", 1L);
    }

    @Test
    public void testCreateFlight() {
        when(flightRepository.save(any(Flight.class))).thenReturn(flight);
        Flight created = flightService.createFlight(flight);
        assertThat(created.getFlightNumber()).isEqualTo("AB123");
        assertThat(created.getTotalSeats()).isEqualTo(10);
        assertThat(created.getAvailableSeats()).isEqualTo(10);
    }

    @Test
    public void testReserveSeat_Success() {
        // Simulamos que el vuelo existe y tiene 10 asientos; luego se reserva uno.
        when(flightRepository.findById(1L)).thenReturn(Optional.of(flight));
        when(flightRepository.save(any(Flight.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Flight updated = flightService.reserveSeat(1L);
        // Se debe haber decrementado 1 asiento
        assertThat(updated.getAvailableSeats()).isEqualTo(9);
    }

    @Test
    public void testReserveSeat_NoSeatsAvailable() {
        // Crear un vuelo con solo 1 asiento, reservarlo y luego intentar reservar otro
        Flight singleSeatFlight = new Flight("AB123", 1);
        ReflectionTestUtils.setField(singleSeatFlight, "id", 1L);
        // Reservamos el único asiento.
        singleSeatFlight.reserveSeat();
        when(flightRepository.findById(1L)).thenReturn(Optional.of(singleSeatFlight));

        assertThatThrownBy(() -> flightService.reserveSeat(1L))
            .isInstanceOf(SeatNotAvailableException.class)
            .hasMessageContaining("No hay asientos disponibles");
    }
}
