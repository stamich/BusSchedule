package pl.mzk.bielsko.service;

import pl.mzk.bielsko.model.Line;

import java.util.List;

public interface LineService {

    void saveLine(Line line);
    void deleteLine(Integer lineId);
    void editLine(Line line);
    Line findLineById(Integer lineId);
    List<Line> findAllLines();
}
