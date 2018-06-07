package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.StopNameDictionary;

import java.util.List;

public interface StopNameDictionaryDao {

    void saveStopName(Integer stopId, StopNameDictionary dictionary);
    void deleteStopName(Integer id);
    StopNameDictionary findStopNameById(Integer id);
    List<StopNameDictionary> findAllStopNames();
    List<StopNameDictionary> findAllStopNames(Integer stopId);
}
