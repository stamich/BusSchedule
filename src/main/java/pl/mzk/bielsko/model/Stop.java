package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
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
    @Column(name = "numer_przystanku", nullable = false, updatable = false)
    private int stopId;

    @Column(name = "ulica", nullable = false)
    private String street;

    @Column(name = "nazwa_przystanku", nullable = false)
    private String stopName;

    @Column(name = "numer_linii", nullable = false)
    private String lineNumber;

    @Column(name = "kierunek", nullable = false)
    private String direction;

    @Column(name = "godzina_odjazdu", nullable = false)
    private LocalTime departTime;

    @ManyToMany(cascade = { CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "przystanek_linia", joinColumns = { @JoinColumn(name = "numer_przystanku") },
            inverseJoinColumns = { @JoinColumn(name = "id_linii") })
    private Set<Line> lines = new HashSet<>();

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

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalTime getDepartTime() {
        return departTime;
    }

    public void setDepartTime(LocalTime departTime) {
        this.departTime = departTime;
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
                ", lineNumber='" + lineNumber + '\'' +
                ", direction='" + direction + '\'' +
                ", departTime=" + departTime +
                ", lines=" + lines +
                '}';
    }
}