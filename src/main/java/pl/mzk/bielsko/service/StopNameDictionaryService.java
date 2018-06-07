package pl.mzk.bielsko.service;

import pl.mzk.bielsko.model.StopNameDictionary;

import java.util.List;

public interface StopNameDictionaryService {

    void saveStopName(Integer stopId, StopNameDictionary dictionary);
    void deleteStopName(Integer id);
    StopNameDictionary findStopNameById(Integer id);
    List<StopNameDictionary> findAllStopNames();
    List<StopNameDictionary> findAllStopNames(Integer stopId);
}
