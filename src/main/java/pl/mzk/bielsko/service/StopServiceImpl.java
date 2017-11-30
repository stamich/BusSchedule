package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.StopDao;
import pl.mzk.bielsko.model.Stop;

import java.util.List;

@Service("stopService")
@Transactional
public class StopServiceImpl implements StopService {

    @Autowired
    private StopDao stopDao;

    @Override
    public void createStop(Stop stop) {
        stopDao.createStop(stop);
    }

    @Override
    public void updateStop(Stop stop) {
        stopDao.updateStop(stop);
    }

    @Override
    public Stop editStop(int stopId) {
        return stopDao.editStop(stopId);
    }

    @Override
    public void deleteStop(int stopId) {
        stopDao.deleteStop(stopId);
    }

    @Override
    public Stop findStop(int stopId) {
        return stopDao.findStop(stopId);
    }

    @Override
    public List<Stop> getAllStops() {
        return stopDao.getAllStops();
    }
}
