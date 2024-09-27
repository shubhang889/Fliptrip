package com.example.fliptrip.service;

import com.example.fliptrip.exception.InvalidFlightException;
import com.example.fliptrip.exception.InvalidInputException;
import com.example.fliptrip.models.dto.FlightRequest;

import static org.springframework.util.ObjectUtils.isEmpty;

public class ValidationService {

    public static void validateFlightRequest(FlightRequest request) throws InvalidInputException {
        if (request.getAirline() == null || request.getAirline().length() <= 2) {
            throw new InvalidFlightException("Airline name must be longer than 2 characters.");
        }

        validateCityCode(request.getSource());
        validateCityCode(request.getDestination());

        if (request.getPrice() <= 0) {
            throw new InvalidFlightException("Flight price must be a positive value.");
        }
    }

    private static void validateCityCode(String city) throws InvalidFlightException {
        if (city == null || city.length() != 3 || !city.matches("[A-Z]{3}")) {
            throw new InvalidFlightException("City code must be a 3-letter uppercase alphabetic string.");
        }
    }

    public static void validateFlightSearchRequest(String source, String destination) throws InvalidInputException {
        if (isEmpty(source) || isEmpty(destination)) {
            throw new InvalidInputException("Source and destination cannot be empty");
        }
    }


}
