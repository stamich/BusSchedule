package pl.mzk.bielsko.dao;

import pl.mzk.bielsko.model.Line;

import java.util.List;

public interface LineDao {

    public void createLine(Line line);
    public void updateLine(Line line);
    public Line editLine(int id);
    public void deleteLine(int id);
    public Line findLine(int id);
    public List<Line> getAllLines();
}
