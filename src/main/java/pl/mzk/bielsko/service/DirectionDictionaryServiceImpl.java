package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.DirectionDictionaryDao;
import pl.mzk.bielsko.model.DirectionDictionary;

import java.util.List;

@Transactional
@Service("directionDictionaryService")
public class DirectionDictionaryServiceImpl implements DirectionDictionaryService {

    @Autowired
    private DirectionDictionaryDao dictionaryDao;

    @Override
    public void saveDirection(Integer stopId, DirectionDictionary dictionary) {
        dictionaryDao.saveDirection(stopId, dictionary);
    }

    @Override
    public void deleteDirection(Integer id) {
        dictionaryDao.deleteDirection(id);
    }

    @Override
    public DirectionDictionary findDirectionById(Integer id) {
        return dictionaryDao.findDirectionById(id);
    }

    @Override
    public List<DirectionDictionary> findAllDirections() {
        return dictionaryDao.findAllDirections();
    }

    @Override
    public List<DirectionDictionary> findAllDirections(Integer stopId) {
        return dictionaryDao.findAllDirections(stopId);
    }
}
