package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.Line;

import java.util.List;

public interface LineDao {

    public void createLine(Line line);
    public void updateLine(Line line);
    public Line editLine(int lineId);
    public void deleteLine(int lineId);
    public Line findLine(int lineId);
    public List<Line> getAllLines();
}
