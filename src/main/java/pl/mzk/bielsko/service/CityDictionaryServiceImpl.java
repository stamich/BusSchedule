package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.CityDictionaryDao;
import pl.mzk.bielsko.model.CityDictionary;

import java.util.List;

@Transactional
@Service("cityDictionaryService")
public class CityDictionaryServiceImpl implements CityDictionaryService {

    @Autowired
    private CityDictionaryDao dictionaryDao;

    @Override
    public void saveCity(Integer stopId, CityDictionary dictionary) {
        dictionaryDao.saveCity(stopId, dictionary);
    }

    @Override
    public void deleteCity(Integer id) {
        dictionaryDao.deleteCity(id);
    }

    @Override
    public void editCity(CityDictionary dictionary) {
        dictionaryDao.editCity(dictionary);
    }

    @Override
    public CityDictionary findCityById(Integer id) {
        return dictionaryDao.findCityById(id);
    }

    @Override
    public List<CityDictionary> findAllCities() {
        return dictionaryDao.findAllCities();
    }

    @Override
    public List<CityDictionary> findAllCities(Integer stopId) {
        return dictionaryDao.findAllCities(stopId);
    }
}
