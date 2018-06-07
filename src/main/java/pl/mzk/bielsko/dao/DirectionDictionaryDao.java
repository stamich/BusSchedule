package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.DirectionDictionary;

import java.util.List;

public interface DirectionDictionaryDao {

    void saveDirection(Integer stopId, DirectionDictionary dictionary);
    void deleteDirection(Integer id);
    DirectionDictionary findDirectionById(Integer id);
    List<DirectionDictionary> findAllDirections();
    List<DirectionDictionary> findAllDirections(Integer stopId);
}
