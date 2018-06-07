package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.Stop;
import pl.mzk.bielsko.model.StopNameDictionary;

import java.util.ArrayList;
import java.util.List;

@Repository("stopNameDictionaryDao")
public class StopNameDictionaryDaoImpl implements StopNameDictionaryDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveStopName(Integer stopId, StopNameDictionary dictionary) {
        currentSession().save(dictionary);

        Stop stop = currentSession().get(Stop.class, stopId);
        stop.getStopNameDictionaries().add(dictionary);
        currentSession().save(stop);
    }

    @Override
    public void deleteStopName(Integer id) {
        StopNameDictionary dictionary = currentSession().get(StopNameDictionary.class, id);
        currentSession().delete(dictionary);
    }

    @Override
    public StopNameDictionary findStopNameById(Integer id) {
        return currentSession().get(StopNameDictionary.class, id);
    }

    @Override
    public List<StopNameDictionary> findAllStopNames() {
        return currentSession().createQuery("FROM StopNameDictionary").list();
    }

    @Override
    public List<StopNameDictionary> findAllStopNames(Integer stopId) {
        String hqlQuery = "SELECT s FROM Stop s LEFT JOIN FETCH s.stopNameDictionaries WHERE s.id.stopId="+stopId;
        Query query = currentSession().createQuery(hqlQuery);
        Stop stop = (Stop) query.uniqueResult();
        return new ArrayList<StopNameDictionary>(stop.getStopNameDictionaries());
    }
}
