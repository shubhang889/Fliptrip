package com.example.fliptrip;

import com.example.fliptrip.models.dao.Flight;
import com.example.fliptrip.models.dto.FlightRequest;
import com.example.fliptrip.models.dto.FlightResponse;
import com.example.fliptrip.models.enums.FlightAddOns;
import com.example.fliptrip.models.enums.FlightFilter;
import com.example.fliptrip.repository.FlightRepository;
import com.example.fliptrip.repository.impl.FlightRepositoryImpl;
import com.example.fliptrip.service.impl.FlightServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import static com.example.fliptrip.models.enums.FlightAddOns.DRINKS;
import static com.example.fliptrip.models.enums.FlightAddOns.MEAL;
import static com.example.fliptrip.models.enums.FlightFilter.CHEAP_FLIGHT;
import static com.example.fliptrip.models.enums.FlightFilter.MIN_HOP_FLIGHT;

@SpringBootApplication
public class FlipTripApplication {

	public static void main(String[] args) {
		FlightRepository flightRepository = new FlightRepositoryImpl();
		FlightServiceImpl flightService = new FlightServiceImpl(flightRepository);

		// Register flights
		flightService.registerFlight(getFlightRequest("JetAir", "CHE", "DEL", 2, 100, Set.of(MEAL)));
		flightService.registerFlight(getFlightRequest("JetAir", "DEL", "CAL", 2, 100, Set.of(MEAL)));
		flightService.registerFlight(getFlightRequest("JetAir", "CAL", "BLR", 2, 100, Set.of(MEAL)));
		flightService.registerFlight(getFlightRequest("JetAir", "BLR", "CHE", 2, 500, Set.of(MEAL)));
		flightService.registerFlight(getFlightRequest("Indigo", "CAL", "BLR", 2, 50, Set.of(DRINKS)));
		flightService.registerFlight(getFlightRequest("JetAir", "CHE", "BOM", 2, 500, Set.of(DRINKS)));
		flightService.registerFlight(getFlightRequest("Indigo", "CHE", "BOM", 2, 5000, Set.of(DRINKS)));
		flightService.registerFlight(getFlightRequest("JetAir", "BOM", "BLR", 2, 500, Set.of(MEAL)));
		flightService.registerFlight(getFlightRequest("JetAir", "CAL", "CHE", 2, 500, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("JetAir", "BLR", "LON", 1, 1000, new HashSet<>()));
//		flightService.registerFlight(getFlightRequest("Delta", "DEL", "LON", 5, 2000, new HashSet<>()));
//		flightService.registerFlight(getFlightRequest("Delta", "LON", "NYC", 5, 2000, new HashSet<>()));
//		flightService.registerFlight(getFlightRequest("IndiGo", "LON", "NYC", 2, 2500, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "DEL", "BLR", 2, 600, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "BLR", "PAR", 6, 800, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "PAR", "LON", 3, 300, Set.of(MEAL)));

//		flightService.registerFlight(getFlightRequest("IndiGo", "DEL", "BOM", 3, 300, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "LKO", "BOM", 3, 300, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "BLY", "DEL", 3, 300, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "BLY", "LKO", 3, 400, Set.of(MEAL)));
		List<FlightResponse> minHopsRoute1 = flightService.searchFlights("CHE", "BLR", Set.of(MEAL), MIN_HOP_FLIGHT);
				System.out.println("\n*Route with Minimum Hops:");
		printRoute(minHopsRoute1);
//		List<FlightResponse> minHopsRoute2 = flightService.searchFlights("CHE", "CHE", new HashSet<>(), MIN_HOP_FLIGHT);
//				System.out.println("\n*Route with Minimum Hops:");
//		printRoute(minHopsRoute2);
		List<FlightResponse> minCOstRoute1 = flightService.searchFlights("CHE", "BLR", Set.of(MEAL), CHEAP_FLIGHT);
				System.out.println("\n*CHEAPEST FLIGHT:");
		printRoute(minCOstRoute1);
//
//		System.out.println("\n*Cheapest Route:");
//		printRoute(cheapestRoute1);
//

		/** In addition to above flights
		 * test case to depict the scenatio of returning the min hops if the user has asked for cheapest flight and we have multiple flights
		 */
//		flightService.registerFlight(getFlightRequest("IndiGo", "DEL", "CHE", 3, 300, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "LKO", "CHE", 3, 300, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "GWL", "DEL", 3, 300, Set.of(MEAL)));
//		flightService.registerFlight(getFlightRequest("IndiGo", "GWL", "LKO", 3, 400, Set.of(MEAL)));

//		Map<String, List<Flight>> allFlights = flightRepository.getAllFlights();
//		for (Map.Entry<String, List<Flight>> entry : allFlights.entrySet()) {
//			System.out.println("source: " + entry.getKey());
//			System.out.println("flights: " + entry.getValue());
//		}
		// Search flights
//		List<FlightResponse> minHopsRoute1 = flightService.searchFlights("DEL", "NYC", new HashSet<>(), MIN_HOP_FLIGHT);
//		List<FlightResponse> cheapestRoute1 = flightService.searchFlights("DEL", "NYC", Set.of(MEAL), CHEAP_FLIGHT);
//		List<FlightResponse> cheapestRoute2 = flightService.searchFlights("DEL", "NYC", new HashSet<>(), CHEAP_FLIGHT);
//		List<FlightResponse> cheapestRoute3 = flightService.searchFlights("BLY", "BOM", new HashSet<>(), CHEAP_FLIGHT);
//		List<FlightResponse> minHopsRoute2 = flightService.searchFlights("BLY", "BOM", new HashSet<>(), MIN_HOP_FLIGHT);

//		List<FlightResponse> minHopsRoute3 = flightService.searchFlights("GWL", "CHE", new HashSet<>(), MIN_HOP_FLIGHT);
//		List<FlightResponse> cheapestRoute4 = flightService.searchFlights("GWL", "CHE", new HashSet<>(), CHEAP_FLIGHT);
//		List<FlightResponse> cheapestRoute3 = flightService.searchFlights("BLR", "DEL", false, true);

		// Print results
//		System.out.println("\n*Route with Minimum Hops:");
//		printRoute(minHopsRoute1);
//
//		System.out.println("\n*Cheapest Route:");
//		printRoute(cheapestRoute1);
//
//		System.out.println("\n*Cheapest Route:");
//		printRoute(cheapestRoute2);

//		System.out.println("\n*Route with Minimum Hops:");
//		printRoute(minHopsRoute1);
//
//		System.out.println("\n*Cheapest Route:");
//		printRoute(cheapestRoute2);

//		System.out.println("\n*Cheapest Route:");
//		printRoute(cheapestRoute3);
	}

	private static void printRoute(List<FlightResponse> route) {
		if (route.isEmpty()) {
			System.out.println("No route found.");
			return;
		}

		int totalCost = 0;
		for (FlightResponse flight : route) {
			System.out.println(flight.getSource() + " to " + flight.getDestination() + " via " + flight.getAirline() + " for " + flight.getPrice());
			totalCost += flight.getPrice();
		}

		System.out.println("Total Flights = " + route.size());
		System.out.println("Total Cost = " + totalCost);
	}

	private static FlightRequest getFlightRequest(String airline, String source, String destination, Integer duration, int price, Set<FlightAddOns> flightAddOns) {
		return new FlightRequest(airline, source, destination, duration, price, flightAddOns);
	}
}
