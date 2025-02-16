package com.example.flightreservation.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.flightreservation.dto.ReservationRequest;
import com.example.flightreservation.dto.ReservationResponse;
import com.example.flightreservation.model.Reservation;
import com.example.flightreservation.service.FlightService;
import com.example.flightreservation.service.ReservationService;

@RestController
@RequestMapping("/api")
public class ReservationController {

    private final ReservationService reservationService;
    private final FlightService flightService;

    @Autowired
    public ReservationController(ReservationService reservationService,
                                 FlightService flightService) {
        this.reservationService = reservationService;
        this.flightService = flightService;
    }

    // Crear una reserva
    @PostMapping("/reservations")
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest request) {
        Reservation reservation = reservationService.createReservation(request.getFlightNumber(), request.getSeatNumber());
        ReservationResponse response = new ReservationResponse(
            reservation.getId(),
            reservation.getFlight().getFlightNumber(),
            reservation.getSeatNumber(),
            reservation.getStatus().name()
        );
        return ResponseEntity.ok(response);
    }

    // Cancelar una reserva
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<ReservationResponse> cancelReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.cancelReservation(id);
        ReservationResponse response = new ReservationResponse(
            reservation.getId(),
            reservation.getFlight().getFlightNumber(),
            reservation.getSeatNumber(),
            reservation.getStatus().name()
        );
        return ResponseEntity.ok(response);
    }

    // Obtener lista de reservas confirmadas para un vuelo
    @GetMapping("/flights/{flightNumber}/reservations")
    public ResponseEntity<List<ReservationResponse>> getReservations(@PathVariable String flightNumber) {
        List<Reservation> reservations = reservationService.getConfirmedReservations(flightNumber);
        List<ReservationResponse> responses = reservations.stream().map(reservation ->
            new ReservationResponse(
                reservation.getId(),
                reservation.getFlight().getFlightNumber(),
                reservation.getSeatNumber(),
                reservation.getStatus().name()
            )
        ).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }
}
