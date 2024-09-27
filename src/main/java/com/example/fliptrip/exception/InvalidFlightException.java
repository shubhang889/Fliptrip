package com.example.fliptrip.exception;

public class InvalidFlightException extends FlightBookingException {
    public InvalidFlightException(String message) {
        super(message);
    }
}