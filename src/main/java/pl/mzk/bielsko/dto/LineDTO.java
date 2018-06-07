package pl.mzk.bielsko.dto;

import pl.mzk.bielsko.model.Stop;

import java.time.LocalDate;
import java.util.List;

public class LineDTO {

    private Integer lineId;
    private String lineNumber;
    private String relationFrom;
    private String relationTo;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Boolean active;
    private String comments;
    private List<Stop> stops;

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

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }
}
