package com.example.fliptrip.repository;

import com.example.fliptrip.models.dao.Flight;
import com.example.fliptrip.models.dto.FlightRequest;

import java.util.List;
import java.util.Map;

public interface FlightRepository {
    void registerFlight(FlightRequest flight);
    List<Flight> getFlightsBySource(String source);

    // For testing purposes
    Map<String, List<Flight>> getAllFlights();
}

