package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.StreetDictionary;

import java.util.List;

public interface StreetDictionaryDao {

    void saveStreet(Integer stopId, StreetDictionary dictionary);
    void deleteStreet(Integer id);
    StreetDictionary findStreetById(Integer id);
    List<StreetDictionary> findAllStreets();
    List<StreetDictionary> findAllStreets(Integer stopId);
}
