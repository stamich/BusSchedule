package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.Stop;

import java.util.List;

@Repository("stopDao")
public class StopDaoImpl implements StopDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void createStop(Stop stop) {
        currentSession().save(stop);
    }

    @Override
    public void updateStop(Stop stop) {
        currentSession().update(stop);
    }

    @Override
    public Stop editStop(int stopId) {
        return findStop(stopId);
    }

    @Override
    public void deleteStop(int stopId) {
        currentSession().delete(stopId);
    }

    @Override
    public Stop findStop(int stopId) {
        return (Stop)currentSession().get(Stop.class, stopId);
    }

    @Override
    public List<Stop> getAllStops() {
        return currentSession().createQuery("from Stop").list();
    }
}
