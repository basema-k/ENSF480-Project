package backend;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * The manager class for handling flight operations: adding, searching, editing, and removing flights.
 *
 *
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-25
 */
public class FlightManager {
    private ArrayList<Flight> flights;

    public FlightManager() {
        flights = new ArrayList<>();
    }

    /**
     * Creates and adds a new flight (admin only).
     *
     * @return the new flight
     * @throws IllegalArgumentException if a flight with the same number already exists on that date
     */
    public Flight addFlight(String flightNumber, Airport source, Airport destination, Airline airline,
                            LocalDate date, LocalTime departureTime, double price) {
        Flight flight = new Flight(flightNumber, source, destination, airline, date, departureTime, price);
        addFlight(flight);
        return flight;
    }

    /** Adds an existing flight object (e.g. one loaded from the database). */
    public void addFlight(Flight flight) {
        if (flights.contains(flight)) {
            throw new IllegalArgumentException("Flight " + flight.getFlightNumber()
                    + " already exists on " + flight.getDate() + ".");
        }
        flights.add(flight);
    }

    /**
     * Searches flights. Any argument can be null to mean "any".
     * Results are sorted by date, then departure time.
     *
     * @param origin      departure airport, or null
     * @param destination arrival airport, or null
     * @param date        departure date, or null
     * @param airline     airline, or null
     * @return matching flights (empty if none match)
     */
    public ArrayList<Flight> searchFlights(Airport origin, Airport destination, LocalDate date, Airline airline) {
        ArrayList<Flight> results = new ArrayList<>();
        for (Flight flight : flights) {
            if (origin != null && !flight.getSource().equals(origin)) continue;
            if (destination != null && !flight.getDestination().equals(destination)) continue;
            if (date != null && !flight.getDate().equals(date)) continue;
            if (airline != null && !flight.getAirline().equals(airline)) continue;
            results.add(flight);
        }
        results.sort(Comparator.comparing(Flight::getDate).thenComparing(Flight::getDepartureTime));
        return results;
    }

    /** Returns every flight, sorted by date then time (used for the flight schedule screen). */
    public ArrayList<Flight> searchFlights() {
        return searchFlights(null, null, null, null);
    }

    /** Returns only flights that still have at least one free seat. */
    public ArrayList<Flight> searchAvailableFlights(Airport origin, Airport destination, LocalDate date, Airline airline) {
        ArrayList<Flight> results = searchFlights(origin, destination, date, airline);
        results.removeIf(f -> f.getAvailableSeatCount() == 0);
        return results;
    }

    /**
     * Finds a flight by its number and date.
     *
     * @return the flight, or null if there is none
     */
    public Flight getFlight(String flightNumber, LocalDate date) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber) && flight.getDate().equals(date)) {
                return flight;
            }
        }
        return null;
    }

    /**
     * Updates a flight's details (admin only). The flight number stays the same.
     *
     * @throws IllegalArgumentException if the flight isn't managed here or a new value is invalid
     */
    public void editFlight(Flight flight, Airport newSource, Airport newDestination, Airline newAirline,
                           LocalDate newDate, LocalTime newDepartureTime, double newPrice) {
        if (!flights.contains(flight)) {
            throw new IllegalArgumentException("Flight not found.");
        }
        // Check everything first so a bad value doesn't leave the flight half-edited.
        if (newSource == null || newDestination == null || newSource.equals(newDestination)) {
            throw new IllegalArgumentException("Source and destination must be set and different.");
        }
        if (newAirline == null || newDate == null || newDepartureTime == null) {
            throw new IllegalArgumentException("Airline, date, and departure time are required.");
        }
        if (newPrice < 0) {
            throw new IllegalArgumentException("Price can't be negative.");
        }
        Flight clash = getFlight(flight.getFlightNumber(), newDate);
        if (clash != null && clash != flight) {
            throw new IllegalArgumentException("Flight " + flight.getFlightNumber()
                    + " already exists on " + newDate + ".");
        }

        flight.setRoute(newSource, newDestination);
        flight.setAirline(newAirline);
        flight.setDate(newDate);
        flight.setDepartureTime(newDepartureTime);
        flight.setPrice(newPrice);
    }

    /**
     * Removes a flight (admin only).
     *
     * @return true if the flight was removed
     */
    public boolean removeFlight(Flight flight) {
        return flights.remove(flight);
    }

    /**
     * Removes all flights whose date has passed.
     *
     * @return how many flights were removed
     */
    public int removeOutdatedFlights() {
        int before = flights.size();
        flights.removeIf(Flight::isOutdated);
        return before - flights.size();
    }

    /** Returns the number of flights. */
    public int getFlightCount() {
        return flights.size();
    }
}
