package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * The POJO (Plain Old Java Object) class for bus stop model.
 * @author Michał Stawarski on 05.06.17.
 * @version 1.0
 */
@Entity
@Table(name = "BUS_STOP_NAME_DICT")
public class StopNameDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "STOP_NAME", nullable = false, length = 50)
    private String stopName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOP_NUMBER")
    private Stop stop;

    // Constructors

    public StopNameDictionary(){
        super();
    }

    public StopNameDictionary(String stopName, Stop stop) {
        this.stopName = stopName;
        this.stop = stop;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

    // Override methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopNameDictionary that = (StopNameDictionary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(stopName, that.stopName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stopName);
    }

    @Override
    public String toString() {
        return "StopNameDictionary{" +
                "id=" + id +
                ", stopName='" + stopName + '\'' +
                '}';
    }
}
