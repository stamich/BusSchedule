package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.Stop;

import java.util.List;

/**
 * Interfejs warstwy danych deklarujacy metody modelu przystanku autobusowego.
 * @author Michal Stawarski
 */
public interface StopDao {

    public void createStop(Stop stop);
    public void updateStop(Stop stop);
    public Stop editStop(int stopId);
    public void deleteStop(int stopId);
    public Stop findStop(int stopId);
    public List<Stop> getAllStops();
}
