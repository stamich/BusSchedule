package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.Line;

import java.util.List;

@Repository("lineDao")
public class LineDaoImpl implements LineDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void createLine(Line line) {
        currentSession().save(line);
    }

    @Override
    public void updateLine(Line line) {
        currentSession().update(line);
    }

    @Override
    public Line editLine(int lineId) {
        return findLine(lineId);
    }

    @Override
    public void deleteLine(int lineId) {
        currentSession().delete(lineId);
    }

    @Override
    public Line findLine(int lineId) {
        return (Line)currentSession().get(Line.class, lineId);
    }

    @Override
    public List<Line> getAllLines() {
        return currentSession().createQuery("from Line").list();
    }
}
