package com.example.flightreservation.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.flightreservation.exception.SeatNotAvailableException;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.repository.FlightRepository;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Optional<Flight> getFlightByNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    @Transactional
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Transactional
    public Flight reserveSeat(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
            .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));
        if (flight.getAvailableSeats() <= 0) {
            throw new SeatNotAvailableException("No hay asientos disponibles para el vuelo " + flight.getFlightNumber());
        }
        flight.reserveSeat();
        return flightRepository.save(flight);
    }

    @Transactional
    public Flight cancelSeat(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
            .orElseThrow(() -> new IllegalArgumentException("Vuelo no encontrado"));
        flight.cancelSeat();
        return flightRepository.save(flight);
    }
}
