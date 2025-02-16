package com.example.flightreservation.repository;

import java.util.Optional;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import com.example.flightreservation.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByFlightNumber(String flightNumber);

    // Se utiliza bloqueo pesimista para evitar condiciones de carrera
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Flight> findById(Long id);
}
