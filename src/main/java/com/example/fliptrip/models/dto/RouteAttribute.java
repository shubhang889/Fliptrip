package com.example.fliptrip.models.dto;

public class RouteAttribute {
    int numberOfHops;
    int totalCost;

    public RouteAttribute(int numberOfHops, int totalCost) {
        this.numberOfHops = numberOfHops;
        this.totalCost = totalCost;
    }

    public int getNumberOfHops() {
        return numberOfHops;
    }

    public int getTotalCost() {
        return totalCost;
    }
}
