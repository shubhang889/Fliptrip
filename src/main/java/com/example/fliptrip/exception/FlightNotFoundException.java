package com.example.fliptrip.exception;

public class FlightNotFoundException extends FlightBookingException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}
