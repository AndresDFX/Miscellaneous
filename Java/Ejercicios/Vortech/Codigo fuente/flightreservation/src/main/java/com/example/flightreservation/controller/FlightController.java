package com.example.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.flightreservation.dto.FlightCreationRequest;
import com.example.flightreservation.dto.FlightResponse;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.service.FlightService;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Endpoint para crear un vuelo
    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightCreationRequest request) {
        Flight flight = new Flight(request.getFlightNumber(), request.getTotalSeats());
        Flight createdFlight = flightService.createFlight(flight);
        FlightResponse response = new FlightResponse(
                createdFlight.getFlightNumber(),
                createdFlight.getTotalSeats(),
                createdFlight.getAvailableSeats()
        );
        return ResponseEntity.ok(response);
    }

    // Endpoint para consultar disponibilidad de asientos
    @GetMapping("/{flightNumber}/availability")
    public ResponseEntity<FlightResponse> getFlightAvailability(@PathVariable String flightNumber) {
        return flightService.getFlightByNumber(flightNumber)
                .map(flight -> ResponseEntity.ok(new FlightResponse(
                        flight.getFlightNumber(),
                        flight.getTotalSeats(),
                        flight.getAvailableSeats())))
                .orElse(ResponseEntity.notFound().build());
    }
}
