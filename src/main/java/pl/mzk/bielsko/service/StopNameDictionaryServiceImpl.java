package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.StopNameDictionaryDao;
import pl.mzk.bielsko.model.StopNameDictionary;

import java.util.List;

@Transactional
@Service("stopNameDictionaryService")
public class StopNameDictionaryServiceImpl implements StopNameDictionaryService {

    @Autowired
    public StopNameDictionaryDao dictionaryDao;

    @Override
    public void saveStopName(Integer stopId, StopNameDictionary dictionary) {
        dictionaryDao.saveStopName(stopId, dictionary);
    }

    @Override
    public void deleteStopName(Integer id) {
        dictionaryDao.deleteStopName(id);
    }

    @Override
    public StopNameDictionary findStopNameById(Integer id) {
        return dictionaryDao.findStopNameById(id);
    }

    @Override
    public List<StopNameDictionary> findAllStopNames() {
        return dictionaryDao.findAllStopNames();
    }

    @Override
    public List<StopNameDictionary> findAllStopNames(Integer stopId) {
        return dictionaryDao.findAllStopNames(stopId);
    }
}
