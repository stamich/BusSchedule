package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.Line;
import pl.mzk.bielsko.model.Stop;

import java.util.List;
import java.util.Set;

@Repository("lineDao")
public class LineDaoImpl implements LineDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveLine(Line line) {
        currentSession().save(line);
    }

    @Override
    public void deleteLine(Integer lineId) {
        String hqlQuery = "FROM Line AS l LEFT JOIN FETCH l.stops WHERE l.id.lineId="+lineId;
        Query query = currentSession().createQuery(hqlQuery);
        Line line = (Line) query.uniqueResult();
        Set<Stop> stops = line.getStops();
        currentSession().delete(line);

        /*
        for(Stop stop: stops){
            currentSession().delete(stop);
        }*/

        stops.stream().forEach((stop) -> {currentSession().delete(stop);
        });
    }

    @Override
    public void editLine(Line line) {
        Line existingLine = currentSession().get(Line.class, line.getLineId());
        existingLine.setLineNumber(line.getLineNumber());
        existingLine.setRelationFrom(line.getRelationFrom());
        existingLine.setRelationTo(line.getRelationTo());
        existingLine.setValidFrom(line.getValidFrom());
        existingLine.setValidTo(line.getValidTo());
        existingLine.setActive(line.getActive());
        existingLine.setComments(line.getComments());
        currentSession().save(existingLine);
    }

    @Override
    public Line findLineById(Integer lineId) {
        String hqlQuery = "FROM Line AS l LEFT JOIN FETCH l.stops WHERE l.id.lineId="+lineId;
        Query query = currentSession().createQuery(hqlQuery);
        return (Line) query.uniqueResult();
    }

    @Override
    public List<Line> findAllLines() {
        return currentSession().createQuery("FROM Line").list();
    }
}
