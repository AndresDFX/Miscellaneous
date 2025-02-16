package com.example.flightreservation.dto;

public class ReservationResponse {
    private Long reservationId;
    private String flightNumber;
    private String seatNumber;
    private String status;

    public ReservationResponse(Long reservationId, String flightNumber, String seatNumber, String status) {
        this.reservationId = reservationId;
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getStatus() {
        return status;
    }
}
