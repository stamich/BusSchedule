package pl.mzk.bielsko.service;

import pl.mzk.bielsko.model.DirectionDictionary;

import java.util.List;

public interface DirectionDictionaryService {

    void saveDirection(Integer stopId, DirectionDictionary dictionary);
    void deleteDirection(Integer id);
    DirectionDictionary findDirectionById(Integer id);
    List<DirectionDictionary> findAllDirections();
    List<DirectionDictionary> findAllDirections(Integer stopId);
}
