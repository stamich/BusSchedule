package pl.mzk.bielsko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mzk.bielsko.dao.LineDao;
import pl.mzk.bielsko.model.Line;

import java.util.List;

@Service("lineService")
@Transactional
public class LineServiceImpl implements LineService {

    @Autowired
    private LineDao lineDao;

    @Override
    public void createLine(Line line) {
        lineDao.createLine(line);
    }

    @Override
    public void updateLine(Line line) {
        lineDao.updateLine(line);
    }

    @Override
    public Line editLine(int lineId) {
        return lineDao.editLine(lineId);
    }

    @Override
    public void deleteLine(int lineId) {
        lineDao.deleteLine(lineId);
    }

    @Override
    public Line findLine(int lineId) {
        return lineDao.findLine(lineId);
    }

    @Override
    public List<Line> getAllLines() {
        return lineDao.getAllLines();
    }
}
