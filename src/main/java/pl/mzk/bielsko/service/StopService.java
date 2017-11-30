package pl.mzk.bielsko.service;

import pl.mzk.bielsko.model.Stop;

import java.util.List;

public interface StopService {

    public void createStop(Stop stop);
    public void updateStop(Stop stop);
    public Stop editStop(int stopId);
    public void deleteStop(int stopId);
    public Stop findStop(int stopId);
    public List<Stop> getAllStops();
}
