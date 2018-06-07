package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.CityDictionary;
import pl.mzk.bielsko.model.Stop;

import java.util.ArrayList;
import java.util.List;

@Repository("cityDictionaryDao")
public class CityDictionaryDaoImpl implements CityDictionaryDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveCity(Integer stopId, CityDictionary dictionary) {
        currentSession().save(dictionary);

        Stop stop = currentSession().get(Stop.class, stopId);
        stop.getCityDictionaries().add(dictionary);
        currentSession().save(stop);
    }

    @Override
    public void deleteCity(Integer id) {
        CityDictionary dictionary = currentSession().get(CityDictionary.class, id);
        currentSession().delete(dictionary);
    }

    @Override
    public void editCity(CityDictionary dictionary) {
        CityDictionary existingDictionary = currentSession().get(CityDictionary.class, dictionary.getId());
        existingDictionary.setCityName(dictionary.getCityName());
        existingDictionary.setStop(dictionary.getStop());
        currentSession().save(existingDictionary);
    }

    @Override
    public CityDictionary findCityById(Integer id) {
        return currentSession().get(CityDictionary.class, id);
    }

    @Override
    public List<CityDictionary> findAllCities() {
        return currentSession().createQuery("FROM CityDictionary").list();
    }

    @Override
    public List<CityDictionary> findAllCities(Integer stopId) {
        String hqlQuery = "SELECT s FROM Stop s LEFT JOIN FETCH s.cityDictionaries WHERE s.id.stopId="+stopId;
        Query query = currentSession().createQuery(hqlQuery);
        Stop stop = (Stop) query.uniqueResult();
        return new ArrayList<CityDictionary>(stop.getCityDictionaries());
    }
}
