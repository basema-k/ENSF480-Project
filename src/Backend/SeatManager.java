package Backend;
import java.util.Map;

/**
 * The manager class for handling seat operations.
 * 
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-25 
 */

public class SeatManager{
    private Map<Seat, Boolean> seats;
    public boolean isOccupied(Seat seat){
        return seats.get(seat);
    }
    public void setOccupied(Seat seat, boolean occupied){
        seats.put(seat, occupied);
    }
}
