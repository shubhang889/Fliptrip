package com.example.fliptrip.repository.impl;

import com.example.fliptrip.models.dao.Flight;
import com.example.fliptrip.models.dto.FlightRequest;
import com.example.fliptrip.repository.FlightRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightRepositoryImpl implements FlightRepository {
    private Map<String, List<Flight>> flightsMap;

    public FlightRepositoryImpl() {
        this.flightsMap = new HashMap<>();
    }

    @Override
    public synchronized void registerFlight(FlightRequest flightRequest) {
        Flight flight = new Flight(flightRequest.getAirline(), flightRequest.getSource(),
                flightRequest.getDestination(), flightRequest.getDuration(), flightRequest.getPrice(), flightRequest.getFlightAddOns());
        flightsMap.computeIfAbsent(flight.getSource(), k -> new ArrayList<>()).add(flight);
        System.out.println(flight.getAirline() + " " + flight.getSource() + " -> " + flight.getDestination() + " flight registered");
    }

    @Override
    public List<Flight> getFlightsBySource(String source) {
        return flightsMap.getOrDefault(source, new ArrayList<>());
    }

    @Override
    public Map<String, List<Flight>> getAllFlights() {
        return flightsMap;
    }
}
