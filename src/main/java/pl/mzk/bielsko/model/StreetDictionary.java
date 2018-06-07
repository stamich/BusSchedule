package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * The POJO (Plain Old Java Object) class for bus stop model.
 * @author Michał Stawarski on 05.06.17.
 * @version 1.0
 */
@Entity
@Table(name = "BUS_STREET_DICT")
public class StreetDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "STREET", nullable = false, length = 30)
    private String street;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOP_NUMBER")
    private Stop stop;

    // Constructors

    public StreetDictionary(){
        super();
    }

    public StreetDictionary(String street, Stop stop) {
        this.street = street;
        this.stop = stop;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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
        StreetDictionary that = (StreetDictionary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, street);
    }

    @Override
    public String toString() {
        return "StreetDictionary{" +
                "id=" + id +
                ", street='" + street + '\'' +
                '}';
    }
}
