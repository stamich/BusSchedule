package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.CityDictionary;

import java.util.List;

public interface CityDictionaryDao {

    void saveCity(Integer stopId, CityDictionary dictionary);
    void deleteCity(Integer id);
    void editCity(CityDictionary dictionary);
    CityDictionary findCityById(Integer id);
    List<CityDictionary> findAllCities();
    List<CityDictionary> findAllCities(Integer stopId);
}
