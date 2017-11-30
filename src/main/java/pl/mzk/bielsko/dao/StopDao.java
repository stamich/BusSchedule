package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.Stop;

import java.util.List;

public interface StopDao {

    public void createStop(Stop stop);
    public void updateStop(Stop stop);
    public Stop editStop(int id);
    public void deleteStop(int id);
    public Stop findStop(int id);
    public List<Stop> getAllStops();
}
