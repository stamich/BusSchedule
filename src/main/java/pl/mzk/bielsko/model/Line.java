package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by michal on 05.06.17.
 */

@Entity
@Table(name = "linia")
public class Line
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linii", nullable = false, updatable = false)
    private int lineId;

    @Column(name = "numer_linii", nullable = false)
    private String lineNumber;

    @Column(name = "relacja", nullable = false)
    private String relation;

    @Column(name = "kierunek", nullable = false)
    private String direction;

    @Column(name = "wazny_od", nullable = false)
    private LocalDate validFrom;

    @Column(name = "wazny_do", nullable = false)
    private LocalDate validTo;

    @ManyToMany(mappedBy = "lines")
    private Set<Stop> stops = new HashSet<>();

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
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

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Set<Stop> getStops() {
        return stops;
    }

    public void setStops(Set<Stop> stops) {
        this.stops = stops;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (lineId != line.lineId) return false;
        return lineNumber.equals(line.lineNumber);
    }

    @Override
    public int hashCode() {
        int result = lineId;
        result = 31 * result + lineNumber.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineId=" + lineId +
                ", lineNumber='" + lineNumber + '\'' +
                ", relation='" + relation + '\'' +
                ", direction='" + direction + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", stops=" + stops +
                '}';
    }
}
