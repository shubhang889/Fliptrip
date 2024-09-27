package com.example.fliptrip.service;

import com.example.fliptrip.models.dto.FlightRequest;
import com.example.fliptrip.models.dto.FlightResponse;
import com.example.fliptrip.models.enums.FlightAddOns;
import com.example.fliptrip.models.enums.FlightFilter;

import java.util.List;
import java.util.Set;

public interface FlightService {
    void registerFlight(FlightRequest flightRequest);
    List<FlightResponse> searchFlights(String source, String destination, Set<FlightAddOns> flightAddOns, FlightFilter flightFilter);
}