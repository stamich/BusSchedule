package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.StreetDictionaryDao;
import pl.mzk.bielsko.model.StreetDictionary;

import java.util.List;

@Transactional
@Service("streetDictionaryService")
public class StreetDictionaryServiceImpl implements StreetDictionaryService {

    @Autowired
    public StreetDictionaryDao dictionaryDao;

    @Override
    public void saveStreet(Integer stopId, StreetDictionary dictionary) {
        dictionaryDao.saveStreet(stopId, dictionary);
    }

    @Override
    public void deleteStreet(Integer id) {
        dictionaryDao.deleteStreet(id);
    }

    @Override
    public StreetDictionary findStreetById(Integer id) {
        return dictionaryDao.findStreetById(id);
    }

    @Override
    public List<StreetDictionary> findAllStreets() {
        return dictionaryDao.findAllStreets();
    }

    @Override
    public List<StreetDictionary> findAllStreets(Integer stopId) {
        return dictionaryDao.findAllStreets(stopId);
    }
}
