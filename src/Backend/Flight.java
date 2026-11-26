package Backend;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The class holding a flight with its specific information such as source, destination, airline, date, and seat management.
 * 
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-25 
 */

public class Flight {
    private Airport source;
    private Airport destination;
    private Airline airline;
    private LocalDate date;
    private SeatManager seats;

public SeatManager getSeats(){
    return seats;
}



