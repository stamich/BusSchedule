package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository("stopDao")
public class StopDaoImpl implements StopDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveStop(Integer lineId, Stop stop) {
        currentSession().save(stop);

        Line line = currentSession().get(Line.class, lineId);
        line.getStops().add(stop);
        currentSession().update(line);
    }

    @Override
    public void editStop(Stop stop) {
        Stop existingStop = currentSession().get(Stop.class, stop.getStopId());
        existingStop.setStopNumber(stop.getStopNumber());
        existingStop.setCityDictionaries(stop.getCityDictionaries());
        existingStop.setStreetDictionaries(stop.getStreetDictionaries());
        existingStop.setStopNameDictionaries(stop.getStopNameDictionaries());
        existingStop.setDirectionDictionaries(stop.getDirectionDictionaries());
        existingStop.setDepartWorking(stop.getDepartWorking());
        existingStop.setDepartSaturdays(stop.getDepartSaturdays());
        existingStop.setDepartSundays(stop.getDepartSundays());
        existingStop.setComments(stop.getComments());

        currentSession().save(existingStop);
    }

    @Override
    public void deleteStop(Integer stopId) {
        String hqlQuery = "FROM Stop AS s LEFT JOIN FETCH s.cityDictionaries, s.directionDictionaries, s.streetDictionaries, s.stopNameDictionaries WHERE s.id.stopId="+stopId;
        Query query = currentSession().createQuery(hqlQuery);
        Stop stop = (Stop) query.uniqueResult();
        Set<CityDictionary> cityDictionaries = stop.getCityDictionaries();
        Set<DirectionDictionary> directionDictionaries = stop.getDirectionDictionaries();
        Set<StreetDictionary> streetDictionaries = stop.getStreetDictionaries();
        Set<StopNameDictionary> stopNameDictionaries = stop.getStopNameDictionaries();
        //Stop stop = currentSession().get(Stop.class, stopId);
        currentSession().delete(stop);

        cityDictionaries.stream().forEach(cityDictionary -> {currentSession().delete(cityDictionary);});
        directionDictionaries.stream().forEach(directionDictionary -> {currentSession().delete(directionDictionary);});
        streetDictionaries.stream().forEach(streetDictionary -> {currentSession().delete(streetDictionary);});
        stopNameDictionaries.stream().forEach(stopNameDictionary -> {currentSession().delete(stopNameDictionary);});
    }

    @Override
    public Stop findStop(Integer stopId) {
        return (Stop)currentSession().get(Stop.class, stopId);
    }

    @Override
    public List<Stop> findAllStops() {
        return currentSession().createQuery("FROM Stop").list();
    }

    @Override
    public List<Stop> findAllStops(Integer lineId) {
        String hqlQuery = "SELECT l FROM Line l LEFT JOIN FETCH l.stops WHERE l.id.lineId="+lineId;
        Query query = currentSession().createQuery(hqlQuery);
        Line line = (Line) query.uniqueResult();
        return new ArrayList<Stop>(line.getStops());
    }
}
