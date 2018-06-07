package pl.mzk.bielsko.service;

import pl.mzk.bielsko.model.Stop;

import java.util.List;

public interface StopService {

    void saveStop(Integer lineId, Stop stop);
    void editStop(Stop stop);
    void deleteStop(Integer stopId);
    Stop findStop(Integer stopId);
    List<Stop> findAllStops();
    List<Stop> findAllStops(Integer lineId);
}
