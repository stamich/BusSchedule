package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.StopDao;
import pl.mzk.bielsko.model.Stop;

import java.util.List;

@Transactional
@Service("stopService")
public class StopServiceImpl implements StopService {

    @Autowired
    private StopDao stopDao;

    public void saveStop(Integer lineId, Stop stop) {
        stopDao.saveStop(lineId, stop);
    }

    public void editStop(Stop stop) {
        stopDao.editStop(stop);
    }

    public void deleteStop(Integer stopId) {
        stopDao.deleteStop(stopId);
    }

    public Stop findStop(Integer stopId) {
        return stopDao.findStop(stopId);
    }

    public List<Stop> findAllStops() {
        return stopDao.findAllStops();
    }

    public List<Stop> findAllStops(Integer lineId) {
        return stopDao.findAllStops(lineId);
    }
}
