# Flight Booking Application

## Overview
This application is designed to allow customers to search for and book flights. Airlines can log in to declare their flight schedules for a given day, and customers can search for flights between two cities. The application supports various features like finding the minimum hops route, finding the cheapest route, and filtering flights based on meal service availability.

## Features
- **Flight Registration**: Airlines can register their flights by specifying the source, destination, price, departure, and arrival times.
- **Search Flights**: Customers can search for flights between two cities with the option to filter results based on meal service availability.
    - **Minimum Hops Route**: Finds the route with the least number of flights (hops) between two cities.
    - **Cheapest Route**: Finds the route with the lowest total cost between two cities.
- **Sorting Functionality**: Customers can sort the flight results by departure or arrival times in ascending or descending order.
- **Extensible Design**: The application is designed to be easily extended to support additional features like filtering based on other services, handling multiple days, etc.
