package com.example.flightreservation.dto;

public class FlightAvailabilityResponse {
    private String flightNumber;
    private int totalSeats;
    private int availableSeats;

    public FlightAvailabilityResponse(String flightNumber, int totalSeats, int availableSeats) {
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
