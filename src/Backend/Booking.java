package backend;

public class Booking {
    private final int id;
    private User customer;
    private Flight flight;
    private Seat seat;

    public Booking(int id, User customer, Flight flight, Seat seat) {
        this.id = id;
        this.customer = customer;
        this.flight = flight;
        this.seat = seat;
    }

    public User getUser() {
        return customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public Seat getSeat() {
        return seat;
    }
}
