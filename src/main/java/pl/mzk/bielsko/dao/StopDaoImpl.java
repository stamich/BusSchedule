package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.Stop;

import java.util.List;

/**
 * Klasa warstwy danych dla modelu przystanku autobusowego.
 * @author Michal Stawarski
 */
@Repository("stopDao")
public class StopDaoImpl implements StopDao{

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metoda tworzaca biezaca sesje
     * @return sessionFactory.getCurrentSession()
     */
    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     * Meroda tworzaca przystanek autobusowy.
     * @param stop
     */
    @Override
    public void createStop(Stop stop) {
        currentSession().save(stop);
    }

    /**
     * Metoda uaktualniajaca przystanek autobusowy.
     * @param stop
     */
    @Override
    public void updateStop(Stop stop) {
        currentSession().update(stop);
    }

    /**
     * Metoda edytujaca przystanek autobusowy.
     * @param stopId
     * @return findStop(stopId)
     */
    @Override
    public Stop editStop(int stopId) {
        return findStop(stopId);
    }

    /**
     * Metoda usuwajaca przystanek autobusowy.
     * @param stopId
     */
    @Override
    public void deleteStop(int stopId) {
        currentSession().delete(stopId);
    }

    /**
     * Metoda odnajdujaca przystanek autobusowy.
     * @param stopId
     * @return (Stop)currentSession().get(Stop.class, stopId)
     */
    @Override
    public Stop findStop(int stopId) {
        return (Stop)currentSession().get(Stop.class, stopId);
    }

    /**
     * Metoda pobierajaca wszystkie przystanki autobusowe poprzez kolekcje List.
     * @return currentSession().createQuery("from Stop").list()
     */
    @Override
    public List<Stop> getAllStops() {
        return currentSession().createQuery("from Stop").list();
    }
}
