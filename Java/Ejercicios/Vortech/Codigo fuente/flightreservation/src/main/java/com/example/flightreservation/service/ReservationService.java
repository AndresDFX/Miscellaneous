package com.example.flightreservation.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.flightreservation.exception.ReservationNotFoundException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.model.Reservation;
import com.example.flightreservation.model.ReservationStatus;
import com.example.flightreservation.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final FlightService flightService;
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              FlightService flightService,
                              KafkaProducerService kafkaProducerService) {
        this.reservationRepository = reservationRepository;
        this.flightService = flightService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Transactional
    public Reservation createReservation(String flightNumber, String seatNumber) {
        Flight flight = flightService.getFlightByNumber(flightNumber)
            .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));

        // Se reserva el asiento utilizando bloqueo pesimista para evitar sobreventa
        flightService.reserveSeat(flight.getId());

        Reservation reservation = new Reservation(flight, seatNumber, ReservationStatus.CONFIRMED);
        Reservation savedReservation = reservationRepository.save(reservation);

        // Publicar evento en Kafka solo si la reserva se confirma
        kafkaProducerService.sendReservationEvent("Reserva confirmada: " + savedReservation.getId());
        return savedReservation;
    }

    @Transactional
    public Reservation cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new ReservationNotFoundException("Reserva no encontrada"));
        reservation.setStatus(ReservationStatus.CANCELED);
        flightService.cancelSeat(reservation.getFlight().getId());
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getConfirmedReservations(String flightNumber) {
        Flight flight = flightService.getFlightByNumber(flightNumber)
            .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));
        return reservationRepository.findByFlightAndStatus(flight, ReservationStatus.CONFIRMED);
    }
}
