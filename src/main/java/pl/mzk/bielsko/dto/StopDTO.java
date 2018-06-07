package pl.mzk.bielsko.dto;

import pl.mzk.bielsko.model.*;

import java.time.LocalTime;
import java.util.List;

public class StopDTO {

    private Integer stopId;
    private Integer stopNumber;
    private LocalTime departWorking;
    private LocalTime departSaturdays;
    private LocalTime departSundays;
    private String comments;
    private Line line;
    private List<CityDictionary> cityDictionaries;
    private List<StreetDictionary> streetDictionaries;
    private List<StopNameDictionary> stopNameDictionaries;
    private List<DirectionDictionary> directionDictionaries;

    // Getters and setters

    public Integer getStopId() {
        return stopId;
    }

    public void setStopId(Integer stopId) {
        this.stopId = stopId;
    }

    public Integer getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(Integer stopNumber) {
        this.stopNumber = stopNumber;
    }

    public LocalTime getDepartWorking() {
        return departWorking;
    }

    public void setDepartWorking(LocalTime departWorking) {
        this.departWorking = departWorking;
    }

    public LocalTime getDepartSaturdays() {
        return departSaturdays;
    }

    public void setDepartSaturdays(LocalTime departSaturdays) {
        this.departSaturdays = departSaturdays;
    }

    public LocalTime getDepartSundays() {
        return departSundays;
    }

    public void setDepartSundays(LocalTime departSundays) {
        this.departSundays = departSundays;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public List<CityDictionary> getCityDictionaries() {
        return cityDictionaries;
    }

    public void setCityDictionaries(List<CityDictionary> cityDictionaries) {
        this.cityDictionaries = cityDictionaries;
    }

    public List<StreetDictionary> getStreetDictionaries() {
        return streetDictionaries;
    }

    public void setStreetDictionaries(List<StreetDictionary> streetDictionaries) {
        this.streetDictionaries = streetDictionaries;
    }

    public List<StopNameDictionary> getStopNameDictionaries() {
        return stopNameDictionaries;
    }

    public void setStopNameDictionaries(List<StopNameDictionary> stopNameDictionaries) {
        this.stopNameDictionaries = stopNameDictionaries;
    }

    public List<DirectionDictionary> getDirectionDictionaries() {
        return directionDictionaries;
    }

    public void setDirectionDictionaries(List<DirectionDictionary> directionDictionaries) {
        this.directionDictionaries = directionDictionaries;
    }
}
