package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by michal on 05.06.17.
 */

@Entity
@Table(name = "linie")
public class Lines
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "numer_linii")
    private int lineNumber;

    @Column(name = "relacja")
    private String relation;

    @Column(name = "kierunek")
    private String direction;


    private Set<Stops> stops;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Set<Stops> getStops() {
        return stops;
    }

    public void setStops(Set<Stops> stops) {
        this.stops = stops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lines lines = (Lines) o;

        return id == lines.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Lines{" +
                "id=" + id +
                ", lineNumber=" + lineNumber +
                ", relation='" + relation + '\'' +
                ", direction='" + direction + '\'' +
                ", stops=" + stops +
                '}';
    }
}
