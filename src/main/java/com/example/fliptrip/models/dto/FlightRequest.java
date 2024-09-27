package com.example.fliptrip.models.dto;

import com.example.fliptrip.models.enums.FlightAddOns;

import java.util.Set;

public class FlightRequest {
    private String airline;
    private String source;
    private String destination;
    private Integer duration;
    private int price;
    private Set<FlightAddOns> flightAddOns;

    public FlightRequest(String airline, String source, String destination, Integer duration, int price, Set<FlightAddOns> flightAddOns) {
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.duration = duration;
        this.flightAddOns = flightAddOns;
        this.price = price;
    }

    public Set<FlightAddOns> getFlightAddOns() {
        return flightAddOns;
    }

    public void setFlightAddOns(Set<FlightAddOns> flightAddOns) {
        this.flightAddOns = flightAddOns;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
