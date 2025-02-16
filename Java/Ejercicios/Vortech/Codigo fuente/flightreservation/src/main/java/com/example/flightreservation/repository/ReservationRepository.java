package com.example.flightreservation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.flightreservation.model.Flight;
import com.example.flightreservation.model.Reservation;
import com.example.flightreservation.model.ReservationStatus;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByFlightAndStatus(Flight flight, ReservationStatus status);
}
