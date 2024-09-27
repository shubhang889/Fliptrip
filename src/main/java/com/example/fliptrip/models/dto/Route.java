package com.example.fliptrip.models.dto;

import com.example.fliptrip.models.dao.Flight;

import java.util.List;

public class Route {
    private List<Flight> flights;
    private int totalCost;
    private int totalHops;

    public Route(List<Flight> flights, int totalCost, int totalHops) {
        this.flights = flights;
        this.totalCost = totalCost;
        this.totalHops = totalHops;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String getLastCity() {
        return flights.isEmpty() ? null : flights.get(flights.size() - 1).getDestination();
    }

    public int getTotalHops() {
        return totalHops;
    }

    public void setTotalHops(int totalHops) {
        this.totalHops = totalHops;
    }
}