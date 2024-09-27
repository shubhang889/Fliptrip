package com.example.fliptrip.models.dto;

public class FlightResponse {
    private String source;
    private String destination;
    private String airline;
    private int price;

    // Constructors, Getters, and Setters

    public FlightResponse(String source, String destination, String airline, int price) {
        this.source = source;
        this.destination = destination;
        this.airline = airline;
        this.price = price;
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

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}