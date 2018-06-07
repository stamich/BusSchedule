package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.Stop;
import pl.mzk.bielsko.model.StreetDictionary;

import java.util.ArrayList;
import java.util.List;

@Repository("streetDictionaryDao")
public class StreetDictionaryDaoImpl implements StreetDictionaryDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveStreet(Integer stopId, StreetDictionary dictionary) {
        currentSession().save(dictionary);

        Stop stop = currentSession().get(Stop.class, stopId);
        stop.getStreetDictionaries().add(dictionary);
        currentSession().save(stop);
    }

    @Override
    public void deleteStreet(Integer id) {
        StreetDictionary dictionary = currentSession().get(StreetDictionary.class, id);
        currentSession().delete(dictionary);
    }

    @Override
    public StreetDictionary findStreetById(Integer id) {
        return currentSession().get(StreetDictionary.class, id);
    }

    @Override
    public List<StreetDictionary> findAllStreets() {
        return currentSession().createQuery("FROM StreetDictionary").list();
    }

    @Override
    public List<StreetDictionary> findAllStreets(Integer stopId) {
        String hqlQuery = "SELECT s FROM Stop s LEFT JOIN FETCH s.streetDictionaries WHERE s.id.stopId="+stopId;
        Query query = currentSession().createQuery(hqlQuery);
        Stop stop = (Stop) query.uniqueResult();
        return new ArrayList<StreetDictionary>(stop.getStreetDictionaries());
    }
}
