# ✈️ Fliptrip – Flight Booking System (Machine Coding Round - Flipkart SDE-II)

This project was built as a solution to the **Flipkart SDE-II Machine Coding Round**. The challenge was to build a minimal yet scalable flight booking system from scratch using only in-memory data structures.

## 🧠 Problem Statement

The system should allow:

- Airlines to register flights for the day.
- Customers to search for flights between two cities.
- Route suggestions based on:
  - ✅ **Minimum number of hops**
  - ✅ **Cheapest route**
- Optional filters for amenities like meal service.
- Bonus: Capability to sort results by departure/arrival time (if available).
- Constraint: No use of databases, CLI or web interface – in-memory only.

---

## ✅ Features Implemented

- Register a flight with: `AirlineName SourceCity DestinationCity Price`
- Search for flights:
  - 🔹 Find the route with **minimum hops**
  - 🔹 Find the **cheapest possible route**
- Filtering support (e.g., meal service using flight attributes)
- Extensible architecture (easy to add filters like business class, drinks, etc.)
- Separation of concerns: Clean modular design
- Bonus:
  - 🚀 Sorting by departure/arrival time (structure ready)
- Graceful handling of invalid inputs and edge cases

---

## 🛠️ Tech Stack

- Java 17
- Object-Oriented Design
- Standard Java collections (no external libraries)

---

## 🏗️ Design Approach

- Built with **modularity**, **extensibility**, and **clean separation of concerns**.
- Core components include:
  - `FlightService`: Registers and stores flights
  - `SearchService`: Handles route finding logic using DFS with priority queues
  - `FilterStrategy`: Interface to support optional filters (like meal service)
  - `MainDriver`: CLI-based test harness for demo purposes

Uses graph-based traversal to find routes between cities.

---

## 🚀 How to Run

1. Clone the repo:

```bash
git clone https://github.com/shubhang889/Fliptrip.git
cd Fliptrip
```
2. Compile and run the MainDriver class (any Java IDE or terminal):

Sample Commands
```bash
register flight-> JetAir -> DEL -> BLR -> 500
register flight-> JetAir -> BLR -> LON -> 1000
register flight-> Delta -> DEL -> LON -> 2000
register flight-> Delta -> LON -> NYC -> 2000
register flight-> IndiGo -> DEL -> BLR -> 600
register flight-> IndiGo -> BLR -> PAR -> 800
register flight-> IndiGo -> PAR -> LON -> 300
register flight-> IndiGo -> LON -> NYC -> 2500

search flight-> DEL -> NYC
```
Output:
```bash
*Route with Minimum Hops:
DEL to LON via Delta for 2000
LON to NYC via Delta for 2000
Total Flights = 2
Total Cost = 4000

Cheapest Route:
DEL to BLR via JetAir for 500
BLR to LON via JetAir for 1000
LON to NYC via Delta for 2000
Total Flights = 3
Total Cost = 3500
```   
