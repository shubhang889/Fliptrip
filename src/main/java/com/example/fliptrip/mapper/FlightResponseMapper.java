package com.example.fliptrip.mapper;

import com.example.fliptrip.models.dao.Flight;
import com.example.fliptrip.models.dto.FlightResponse;

import java.util.ArrayList;
import java.util.List;

public class FlightResponseMapper {

    // Convert DAO to DTO
    public static List<FlightResponse> mapFlightResponse(List<Flight> flights) {
        List<FlightResponse> responseList = new ArrayList<>();
        for (Flight flight : flights) {
            responseList.add(new FlightResponse(flight.getSource(), flight.getDestination(),
                    flight.getAirline(), flight.getPrice()));
        }
        return responseList;
    }

}
