package com.example.fliptrip.models.dao;

import com.example.fliptrip.models.enums.FlightAddOns;

import java.util.Set;

public class Flight {
    String airline;
    String source;
    String destination;
    Integer duration;
    int price;
    Set<FlightAddOns> flightAddOns;

    public Flight(String airline, String source, String destination, Integer duration, int price,  Set<FlightAddOns> flightAddOns) {
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.duration = duration;
        this.flightAddOns = flightAddOns;
    }

    public String getAirline() {
        return airline;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrice() {
        return price;
    }

    public boolean containsAllAddOns(Set<FlightAddOns> flightAddOnsList) {
        return flightAddOns.containsAll(flightAddOnsList);
    }

    @Override
    public String toString() {
        return source + " to " + destination + " via " + airline + " for " + price;
    }
}
