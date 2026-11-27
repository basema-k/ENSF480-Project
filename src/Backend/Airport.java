package backend;

import java.util.Objects;

/**
 * An airport that a flight can leave from or arrive at.
 * Two airports are equal if they have the same IATA code (e.g. "YYC").
 *
 * @author Basema Khan, Max Boucher, Abdelrahman ElSayed, and Simon Ryabinkin
 * @version 1.0
 * @since 2026-11-26
 */
public class Airport {
    private String code;
    private String city;
    private String name;

    public Airport(String code, String city, String name) {
        this.code = code.toUpperCase();
        this.city = city;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getCity() { return city; }
    public String getName() { return name; }

    public void setCity(String city) { this.city = city; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        return code.equals(((Airport) o).code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return city + " (" + code + ")";
    }
}
