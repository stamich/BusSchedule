package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.LineDao;
import pl.mzk.bielsko.model.Line;

import java.util.List;

@Transactional
@Service("lineService")
public class LineServiceImpl implements LineService {

    @Autowired
    private LineDao lineDao;

    @Override
    public void saveLine(Line line) {
        lineDao.saveLine(line);
    }

    @Override
    public void deleteLine(Integer lineId) {
        lineDao.deleteLine(lineId);
    }

    @Override
    public void editLine(Line line) {
        lineDao.editLine(line);
    }

    @Override
    public Line findLineById(Integer lineId) {
        return lineDao.findLineById(lineId);
    }

    @Override
    public List<Line> findAllLines() {
        return lineDao.findAllLines();
    }
}
