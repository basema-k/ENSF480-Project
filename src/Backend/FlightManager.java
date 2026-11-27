import java.time.LocalDate;
import java.util.ArrayList;
package Backend;

/**
 * The manager class for handling flight operations.
 * 
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-25 
 */

public class FlightManager {
    private ArrayList<Flight> flights;

    public void addFlight(Airport source, Airport destination, Airline airline, LocalDate date) {
        Flight flight = new Flight(source, destination, airline, date);
        flights.add(flight);
    }

    public ArrayList<Flight> searchFlights();

    public void editFlight(Flight flight, Airport newSource, Airport newDestination, Airline newAirline, LocalDate newDate) {
        flight.setSource(newSource);
        flight.setDestination(newDestination);
        flight.setAirline(newAirline);
        flight.setDate(newDate);
    }

    public void removeFlight(Flight flight){
        flights.remove(flight);
    }
    
}
