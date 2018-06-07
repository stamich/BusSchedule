package pl.mzk.bielsko.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The POJO (Plain Old Java Object) class for bus line model.
 * @author Michał Stawarski on 05.06.17.
 * @version 1.0
 */
@Entity
@Table(name = "BUS_LINE")
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LINE_ID", nullable = false, updatable = false)
    private Integer lineId;

    @NaturalId
    @Column(name = "LINE_NUMBER", nullable = false, length = 5)
    private String lineNumber;

    @Column(name = "RELATION_FROM", nullable = false, length = 30)
    private String relationFrom;

    @Column(name = "RELATION_TO", nullable = false, length = 30)
    private String relationTo;

    @Column(name = "VALID_FROM", nullable = false)
    private LocalDate validFrom;

    @Column(name = "VALID_TO", nullable = false)
    private LocalDate validTo;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @Column(name = "COMMENTS", length = 50)
    private String comments;

    @OneToMany(mappedBy = "line", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<Stop> stops = new HashSet<>();

    // Constructors

    public Line(){
        super();
    }

    public Line(String lineNumber, String relationFrom, String relationTo, LocalDate validFrom, LocalDate validTo, Boolean active, String comments) {
        this.lineNumber = lineNumber;
        this.relationFrom = relationFrom;
        this.relationTo = relationTo;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.active = active;
        this.comments = comments;
    }

    // Getters and setters

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getRelationFrom() {
        return relationFrom;
    }

    public void setRelationFrom(String relationFrom) {
        this.relationFrom = relationFrom;
    }

    public String getRelationTo() {
        return relationTo;
    }

    public void setRelationTo(String relationTo) {
        this.relationTo = relationTo;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<Stop> getStops() {
        return stops;
    }

    public void setStops(Set<Stop> stops) {
        this.stops = stops;
    }

    // Override methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(lineId, line.lineId) &&
                Objects.equals(lineNumber, line.lineNumber) &&
                Objects.equals(relationFrom, line.relationFrom) &&
                Objects.equals(relationTo, line.relationTo) &&
                Objects.equals(validFrom, line.validFrom) &&
                Objects.equals(validTo, line.validTo) &&
                Objects.equals(active, line.active) &&
                Objects.equals(comments, line.comments);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lineId, lineNumber, relationFrom, relationTo, validFrom, validTo);
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineId=" + lineId +
                ", lineNumber='" + lineNumber + '\'' +
                ", relationFrom='" + relationFrom + '\'' +
                ", relationTo='" + relationTo + '\'' +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", active=" + active +
                ", comments='" + comments + '\'' +
                '}';
    }
}
