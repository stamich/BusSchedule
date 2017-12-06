package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.StopDao;
import pl.mzk.bielsko.model.Stop;

import java.util.List;

/**
 * Klasa warstwy uslug dla modelu przystanku autobusowego.
 * @author Michal Stawarski
 */
@Service("stopService")
@Transactional
public class StopServiceImpl implements StopService {

    @Autowired
    private StopDao stopDao;

    /**
     * Meroda tworzaca przystanek autobusowy.
     * @param stop
     */
    @Override
    public void createStop(Stop stop) {
        stopDao.createStop(stop);
    }

    /**
     * Metoda uaktualniajaca przystanek autobusowy.
     * @param stop
     */
    @Override
    public void updateStop(Stop stop) {
        stopDao.updateStop(stop);
    }

    /**
     * Metoda edytujaca przystanek autobusowy.
     * @param stopId
     * @return stopDao.editStop(stopId)
     */
    @Override
    public Stop editStop(int stopId) {
        return stopDao.editStop(stopId);
    }

    /**
     * Metoda usuwajaca przystanek autobusowy.
     * @param stopId
     */
    @Override
    public void deleteStop(int stopId) {
        stopDao.deleteStop(stopId);
    }

    /**
     * Metoda odnajdujaca przystanek autobusowy.
     * @param stopId
     * @return stopDao.findStop(stopId)
     */
    @Override
    public Stop findStop(int stopId) {
        return stopDao.findStop(stopId);
    }

    /**
     * Metoda pobierajaca wszystkie przystanki autobusowe poprzez kolekcje List.
     * @return stopDao.getAllStops()
     */
    @Override
    public List<Stop> getAllStops() {
        return stopDao.getAllStops();
    }
}
