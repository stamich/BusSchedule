package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * The POJO (Plain Old Java Object) class for bus stop model.
 * @author Michał Stawarski on 05.06.17.
 * @version 1.0
 */
@Entity
@Table(name = "BUS_CITY_DICT")
public class CityDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "CITY_NAME", nullable = false, length = 20)
    private String cityName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOP_NUMBER")
    private Stop stop;

    // Constructors

    public CityDictionary(){
        super();
    }

    public CityDictionary(String cityName, Stop stop) {
        this.cityName = cityName;
        this.stop = stop;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
        CityDictionary that = (CityDictionary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cityName);
    }

    @Override
    public String toString() {
        return "CityDictionary{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
