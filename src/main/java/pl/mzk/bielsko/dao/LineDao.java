package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.Line;

import java.util.List;

public interface LineDao {

    void saveLine(Line line);
    void deleteLine(Integer lineId);
    void editLine(Line line);
    Line findLineById(Integer lineId);
    List<Line> findAllLines();
}
