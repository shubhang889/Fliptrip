package com.example.fliptrip.service.impl;

import com.example.fliptrip.exception.FlightNotFoundException;
import com.example.fliptrip.exception.InvalidInputException;
import com.example.fliptrip.models.dao.Flight;
import com.example.fliptrip.models.dto.FlightRequest;
import com.example.fliptrip.models.dto.FlightResponse;
import com.example.fliptrip.models.dto.Route;
import com.example.fliptrip.models.dto.RouteAttribute;
import com.example.fliptrip.models.enums.FlightAddOns;
import com.example.fliptrip.models.enums.FlightFilter;
import com.example.fliptrip.repository.FlightRepository;
import com.example.fliptrip.service.FlightService;

import java.util.*;

import static com.example.fliptrip.mapper.FlightResponseMapper.mapFlightResponse;
import static com.example.fliptrip.models.enums.FlightFilter.CHEAP_FLIGHT;
import static com.example.fliptrip.service.ValidationService.validateFlightRequest;
import static com.example.fliptrip.service.ValidationService.validateFlightSearchRequest;

public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void registerFlight(FlightRequest flightRequest) {
        validateFlightRequest(flightRequest);
        flightRepository.registerFlight(flightRequest);
    }

    /**
     *  BFS, Dijkstra's algo
     *  BFS can also fulfil the condition BUT
     *  using Dijkstra makes the code extensible to further searches like minimum time to reach the destination, etc.
     * @param source
     * @param destination
     * @param flightAddOns
     * @param flightFilter
     * @return
     * @throws InvalidInputException
     */
    @Override
    public List<FlightResponse> searchFlights(String source,
                                              String destination,
                                              Set<FlightAddOns> flightAddOns,
                                              FlightFilter flightFilter) throws InvalidInputException {
        validateFlightSearchRequest(source, destination);
        return flightFilter.equals(CHEAP_FLIGHT)
                ? findCheapestRoute(source, destination, flightAddOns)
                : findMinHopsRoute(source, destination, flightAddOns);
    }

    /**
     * Implement Dijikstra's algo to find the shortest past between source and the destination with a weighted edges.
     * @param source
     * @param destination
     * @param flightAddOns
     * @return
     * @throws FlightNotFoundException
     */
    private List<FlightResponse> findMinHopsRoute(String source, String destination, Set<FlightAddOns> flightAddOns)
            throws FlightNotFoundException {
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(Route::getTotalHops));
        pq.add(new Route(new ArrayList<>(), 0, 0));

        Map<String, Integer> hopsMap = new HashMap<>();
        hopsMap.put(source, 0);

        while (!pq.isEmpty()) {
            Route currentRoute = pq.poll();
            String currentCity = currentRoute.getLastCity() == null ? source : currentRoute.getLastCity();

            if (currentCity.equals(destination)) {
                return mapFlightResponse(currentRoute.getFlights());
            }

            exploreAllFlightsFromCity(pq, currentRoute, hopsMap, currentCity, flightAddOns);
        }

        throw new FlightNotFoundException("Flights not found for the specified source and destination");
    }

    /** This is the util method to explore all the possible ways to reach the destination.
     * @param pq
     * @param currentRoute
     * @param hopsMap
     * @param currentCity
     * @param flightAddOns
     */
    private void exploreAllFlightsFromCity(PriorityQueue<Route> pq,
                                           Route currentRoute,
                                           Map<String, Integer> hopsMap,
                                           String currentCity,
                                           Set<FlightAddOns> flightAddOns) {
        for (Flight flight : flightRepository.getFlightsBySource(currentCity)) {
            if (flight.containsAllAddOns(flightAddOns)) {
                int newHops = currentRoute.getTotalHops() + 1;
                if (newHops < hopsMap.getOrDefault(flight.getDestination(), Integer.MAX_VALUE)) {
                    hopsMap.put(flight.getDestination(), newHops);
                    List<Flight> newFlights = new ArrayList<>(currentRoute.getFlights());
                    newFlights.add(flight);
                    pq.add(new Route(newFlights, currentRoute.getTotalCost() + flight.getPrice(), newHops));
                }
            }
        }
    }

    private List<FlightResponse> findCheapestRoute(String source, String destination, Set<FlightAddOns> flightAddOns)
            throws FlightNotFoundException {
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(Route::getTotalCost));
        pq.add(new Route(new ArrayList<>(), 0, 0));

        // To keep the track of visited cities
        Map<String, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            // Retrieve and remove the route with the lowest total cost
            Route currentRoute = pq.poll();

            // Determine the current city; use source if the route is empty
            String currentCity = currentRoute.getLastCity() == null ? source : currentRoute.getLastCity();

            if (currentCity.equals(destination)) {
                // current city is the destination
                return mapFlightResponse(currentRoute.getFlights());
            }

            if (visited.containsKey(currentCity) && visited.get(currentCity) <= currentRoute.getTotalCost()) {
                continue;
            }

            visited.put(currentCity, currentRoute.getTotalCost());

            exploreAllFlightsFromCity(pq, currentRoute, flightAddOns, currentCity);
        }

        throw new FlightNotFoundException("Flights not found for the specified source and destination");
    }

    private void exploreAllFlightsFromCity(PriorityQueue<Route> pq, Route currentRoute, Set<FlightAddOns> flightAddOns, String currentCity) {
        for (Flight flight : flightRepository.getFlightsBySource(currentCity)) {
            if (flight.containsAllAddOns(flightAddOns)) {
                // Create a new list of flights by adding the current flight to the existing route
                List<Flight> newFlights = new ArrayList<>(currentRoute.getFlights());
                newFlights.add(flight);
                // Add the new route to the priority queue with the updated total cost
                pq.add(new Route(newFlights, currentRoute.getTotalCost() + flight.getPrice(), currentRoute.getTotalHops() + 1));
            }
        }
    }

}
