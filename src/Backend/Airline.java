package backend;

import java.util.Objects;

/**
 * An airline that operates flights.
 * Two airlines are equal if they have the same code (e.g. "WS" for WestJet).
 *
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-26
 */
public class Airline {
    private String code;
    private String name;

    public Airline(String code, String name) {
        this.code = code.toUpperCase();
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;
        return code.equals(((Airline) o).code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return name;
    }
}
