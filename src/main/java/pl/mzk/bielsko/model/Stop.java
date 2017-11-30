package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by michal on 05.06.17.
 */

@Entity
@Table(name = "przystanek")
public class Stop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int stopId;

    @Column(name = "ulica")
    private String street;

    @Column(name = "nazwa_przystanku")
    private String stopName;

    @Column(name = "numer_linii")
    private int lineNumber;

    @Column(name = "kierunek")
    private String direction;


    private Set<Line> lines;


    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
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

    public Set<Line> getLines() {
        return lines;
    }

    public void setLines(Set<Line> lines) {
        this.lines = lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stop stop = (Stop) o;

        return stopId == stop.stopId;
    }

    @Override
    public int hashCode() {
        return stopId;
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId=" + stopId +
                ", street='" + street + '\'' +
                ", stopName='" + stopName + '\'' +
                ", lineNumber=" + lineNumber +
                ", direction='" + direction + '\'' +
                ", lines=" + lines +
                '}';
    }
}