package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.DirectionDictionary;
import pl.mzk.bielsko.model.Stop;

import java.util.ArrayList;
import java.util.List;

@Repository("directionDictionaryDao")
public class DirectionDictionaryDaoImpl implements DirectionDictionaryDao{

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveDirection(Integer stopId, DirectionDictionary dictionary) {
        currentSession().save(dictionary);

        Stop stop = currentSession().get(Stop.class, stopId);
        stop.getDirectionDictionaries().add(dictionary);
        currentSession().save(stop);
    }

    @Override
    public void deleteDirection(Integer id) {
        DirectionDictionary dictionary = currentSession().get(DirectionDictionary.class, id);
        currentSession().delete(dictionary);
    }

    @Override
    public DirectionDictionary findDirectionById(Integer id) {
        return currentSession().get(DirectionDictionary.class, id);
    }

    @Override
    public List<DirectionDictionary> findAllDirections() {
        return currentSession().createQuery("FROM DirectionDictionary").list();
    }

    @Override
    public List<DirectionDictionary> findAllDirections(Integer stopId) {
        String hqlQuery = "SELECT s FROM Stop s LEFT JOIN FETCH s.directionDictionaries WHERE s.id.stopId="+stopId;
        Query query = currentSession().createQuery(hqlQuery);
        Stop stop = (Stop) query.uniqueResult();
        return new ArrayList<DirectionDictionary>(stop.getDirectionDictionaries());
    }
}
