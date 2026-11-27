package backend;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The class holding a flight with its specific information such as source, destination, airline, date, and seat management.
 *
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-25
 */
public class Flight {
    private String flightNumber;
    private Airport source;
    private Airport destination;
    private Airline airline;
    private LocalDate date;
    private LocalTime departureTime;
    private double price;
    private SeatManager seats;

    /**
     * Creates a flight with the default seat layout.
     *
     * @param flightNumber  unique flight number, e.g. "WS123"
     * @param source        departure airport
     * @param destination   arrival airport
     * @param airline       airline operating the flight
     * @param date          departure date
     * @param departureTime departure time
     * @param price         price of one seat
     */
    public Flight(String flightNumber, Airport source, Airport destination, Airline airline,
                  LocalDate date, LocalTime departureTime, double price) {
        this(flightNumber, source, destination, airline, date, departureTime, price, new SeatManager());
    }

    /** Creates a flight with a custom seat layout. */
    public Flight(String flightNumber, Airport source, Airport destination, Airline airline,
                  LocalDate date, LocalTime departureTime, double price, SeatManager seats) {
        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Flight number is required.");
        }
        this.flightNumber = flightNumber.toUpperCase();
        setRoute(source, destination);
        setAirline(airline);
        setDate(date);
        setDepartureTime(departureTime);
        setPrice(price);
        this.seats = seats;
    }

    public String getFlightNumber() { return flightNumber; }
    public Airport getSource() { return source; }
    public Airport getDestination() { return destination; }
    public Airline getAirline() { return airline; }
    public LocalDate getDate() { return date; }
    public LocalTime getDepartureTime() { return departureTime; }
    public double getPrice() { return price; }
    public SeatManager getSeats() { return seats; }

    /** Sets both airports at once (use this when changing both, so they're checked together). */
    public void setRoute(Airport source, Airport destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination airports are required.");
        }
        if (source.equals(destination)) {
            throw new IllegalArgumentException("Source and destination must differ.");
        }
        this.source = source;
        this.destination = destination;
    }

    public void setSource(Airport source) {
        if (source == null) throw new IllegalArgumentException("Source airport is required.");
        if (source.equals(destination)) throw new IllegalArgumentException("Source and destination must differ.");
        this.source = source;
    }

    public void setDestination(Airport destination) {
        if (destination == null) throw new IllegalArgumentException("Destination airport is required.");
        if (destination.equals(source)) throw new IllegalArgumentException("Source and destination must differ.");
        this.destination = destination;
    }

    public void setAirline(Airline airline) {
        if (airline == null) throw new IllegalArgumentException("Airline is required.");
        this.airline = airline;
    }

    public void setDate(LocalDate date) {
        if (date == null) throw new IllegalArgumentException("Date is required.");
        this.date = date;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) throw new IllegalArgumentException("Departure time is required.");
        this.departureTime = departureTime;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price can't be negative.");
        this.price = price;
    }