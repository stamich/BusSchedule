package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.Stop;

import java.util.List;

public interface StopDao {

    void saveStop(Integer lineId, Stop stop);
    void editStop(Stop stop);
    void deleteStop(Integer stopId);
    Stop findStop(Integer stopId);
    List<Stop> findAllStops();
    List<Stop> findAllStops(Integer lineId);
}
