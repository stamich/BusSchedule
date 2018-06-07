package pl.mzk.bielsko.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The POJO (Plain Old Java Object) class for bus stop model.
 * @author Michał Stawarski on 05.06.17.
 * @version 1.0
 */
@Entity
@Table(name = "BUS_STOP")
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOP_ID", nullable = false, updatable = false)
    private Integer stopId;

    @NaturalId
    @Column(name = "STOP_NUMBER", nullable = false)
    private Integer stopNumber;

    @Column(name = "DEPART_WORKING_DAYS")
    private LocalTime departWorking;

    @Column(name = "DEPART_SATURDAYS")
    private LocalTime departSaturdays;

    @Column(name = "DEPART_SUNDAYS")
    private LocalTime departSundays;

    @Column(name = "COMMENTS", length = 50)
    private String comments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LINE_NUMBER")
    private Line line;

    @OneToMany(mappedBy = "stop", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<CityDictionary> cityDictionaries = new HashSet<>();

    @OneToMany(mappedBy = "stop", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<StreetDictionary> streetDictionaries = new HashSet<>();

    @OneToMany(mappedBy = "stop", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<StopNameDictionary> stopNameDictionaries = new HashSet<>();

    @OneToMany(mappedBy = "stop", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    private Set<DirectionDictionary> directionDictionaries = new HashSet<>();

    // Constructors

    public Stop(){
        super();
    }

    public Stop(Integer stopNumber, LocalTime departWorking, LocalTime departSaturdays, LocalTime departSundays, String comments, Line line, Set<CityDictionary> cityDictionaries, Set<StreetDictionary> streetDictionaries,
                Set<StopNameDictionary> stopNameDictionaries, Set<DirectionDictionary> directionDictionaries) {
        this.stopNumber = stopNumber;
        this.departWorking = departWorking;
        this.departSaturdays = departSaturdays;
        this.departSundays = departSundays;
        this.comments = comments;
        this.line = line;
        this.cityDictionaries = cityDictionaries;
        this.streetDictionaries = streetDictionaries;
        this.stopNameDictionaries = stopNameDictionaries;
        this.directionDictionaries = directionDictionaries;
    }

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

    public Set<CityDictionary> getCityDictionaries() {
        return cityDictionaries;
    }

    public void setCityDictionaries(Set<CityDictionary> cityDictionaries) {
        this.cityDictionaries = cityDictionaries;
    }

    public Set<StreetDictionary> getStreetDictionaries() {
        return streetDictionaries;
    }

    public void setStreetDictionaries(Set<StreetDictionary> streetDictionaries) {
        this.streetDictionaries = streetDictionaries;
    }

    public Set<StopNameDictionary> getStopNameDictionaries() {
        return stopNameDictionaries;
    }

    public void setStopNameDictionaries(Set<StopNameDictionary> stopNameDictionaries) {
        this.stopNameDictionaries = stopNameDictionaries;
    }

    public Set<DirectionDictionary> getDirectionDictionaries() {
        return directionDictionaries;
    }

    public void setDirectionDictionaries(Set<DirectionDictionary> directionDictionaries) {
        this.directionDictionaries = directionDictionaries;
    }

    // Override methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return Objects.equals(stopId, stop.stopId) &&
                Objects.equals(stopNumber, stop.stopNumber) &&
                Objects.equals(departWorking, stop.departWorking) &&
                Objects.equals(departSaturdays, stop.departSaturdays) &&
                Objects.equals(departSundays, stop.departSundays) &&
                Objects.equals(comments, stop.comments);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stopId, stopNumber, departWorking, departSaturdays, departSundays, comments);
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId=" + stopId +
                ", stopNumber=" + stopNumber +
                ", departWorking=" + departWorking +
                ", departSaturdays=" + departSaturdays +
                ", departSundays=" + departSundays +
                ", comments='" + comments + '\'' +
                '}';
    }
}