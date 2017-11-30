package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by michal on 05.06.17.
 */

@Entity
@Table(name = "przystanki")
public class Stops
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "ulica")
    private String street;

    @Column(name = "nazwa_przystanku")
    private String stopName;

    @Column(name = "numer_linii")
    private int lineNumber;

    @Column(name = "kierunek")
    private String direction;


    private Set<Lines> lines;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Set<Lines> getLines() {
        return lines;
    }

    public void setLines(Set<Lines> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stops stops = (Stops) o;

        return id == stops.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Stops{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", stopName='" + stopName + '\'' +
                ", lineNumber=" + lineNumber +
                ", direction='" + direction + '\'' +
                ", lines=" + lines +
                '}';
    }
}