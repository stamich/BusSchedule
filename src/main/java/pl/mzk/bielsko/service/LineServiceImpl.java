package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.LineDao;
import pl.mzk.bielsko.model.Line;

import java.util.List;

/**
 * Klasa warstwy uslug dla modelu linii autobusowej.
 * @author Michal Stawarski
 */
@Service("lineService")
@Transactional
public class LineServiceImpl implements LineService {

    @Autowired
    private LineDao lineDao;

    /**
     * Meroda tworzaca linie autobusowa.
     * @param line
     */
    @Override
    public void createLine(Line line) {
        lineDao.createLine(line);
    }

    /**
     * Metoda uaktualniajaca linie autobusowa.
     * @param line
     */
    @Override
    public void updateLine(Line line) {
        lineDao.updateLine(line);
    }

    /**
     * Metoda edytujaca linie autobusowa.
     * @param lineId
     * @return lineDao.editLine(lineId)
     */
    @Override
    public Line editLine(int lineId) {
        return lineDao.editLine(lineId);
    }

    /**
     * Metoda usuwajaca linie autobusowa.
     * @param lineId
     */
    @Override
    public void deleteLine(int lineId) {
        lineDao.deleteLine(lineId);
    }

    /**
     * Metoda odnajdujaca linie autobusowa.
     * @param lineId
     * @return lineDao.findLine(lineId)
     */
    @Override
    public Line findLine(int lineId) {
        return lineDao.findLine(lineId);
    }

    /**
     * Metoda pobierajaca wszystkie linie autobusowe poprzez kolekcje List.
     * @return lineDao.getAllLines()
     */
    @Override
    public List<Line> getAllLines() {
        return lineDao.getAllLines();
    }
}
