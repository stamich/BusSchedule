package pl.mzk.bielsko.service;

import pl.mzk.bielsko.model.CityDictionary;

import java.util.List;

public interface CityDictionaryService {

    void saveCity(Integer stopId, CityDictionary dictionary);
    void deleteCity(Integer id);
    void editCity(CityDictionary dictionary);
    CityDictionary findCityById(Integer id);
    List<CityDictionary> findAllCities();
    List<CityDictionary> findAllCities(Integer stopId);
}
