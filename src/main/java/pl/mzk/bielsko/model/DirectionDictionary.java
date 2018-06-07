package pl.mzk.bielsko.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * The POJO (Plain Old Java Object) class for bus stop model.
 * @author Michał Stawarski on 05.06.17.
 * @version 1.0
 */
@Entity
@Table(name = "BUS_DIRECTION_DICT")
public class DirectionDictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "DIRECTION", nullable = false, length = 20)
    private String direction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STOP_NUMBER")
    private Stop stop;

    // Constructors

    public DirectionDictionary(){
        super();
    }

    public DirectionDictionary(String direction, Stop stop) {
        this.direction = direction;
        this.stop = stop;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
        DirectionDictionary that = (DirectionDictionary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, direction);
    }

    @Override
    public String toString() {
        return "DirectionDictionary{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                '}';
    }
}
