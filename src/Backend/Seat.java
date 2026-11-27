package backend;

import java.util.Objects;

/**
 * The class holding a seat with its specific information such as the letter and number of the seat.
 * Seats are used as keys in SeatManager's map, so equals() and hashCode() compare row number and letter.
 *
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-25
 */
public class Seat implements Comparable<Seat> {
    private final char letter;
    private final int number;

    public Seat(int number, char letter) {
        this.number = number;
        this.letter = Character.toUpperCase(letter);
    }

    public char getLetter() { return letter; }
    public int getNumber() { return number; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat other = (Seat) o;
        return number == other.number && letter == other.letter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, letter);
    }

    /** Orders seats by row, then letter */
    @Override
    public int compareTo(Seat other) {
        if (number != other.number) return Integer.compare(number, other.number);
        return Character.compare(letter, other.letter);
    }

    /** Returns the seat label (12C, for example) */
    @Override
    public String toString() {
        return number + "" + letter;
    }
}
