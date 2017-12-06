package pl.mzk.bielsko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.mzk.bielsko.model.Line;

import java.util.List;

/**
 * Klasa warstwy danych dla modelu linii autobusowej.
 * @author Michal Stawarski
 */
@Repository("lineDao")
public class LineDaoImpl implements LineDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Metoda tworzaca biezaca sesje
     * @return sessionFactory.getCurrentSession()
     */
    protected Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     * Meroda tworzaca linie autobusowa.
     * @param line
     */
    @Override
    public void createLine(Line line) {
        currentSession().save(line);
    }

    /**
     * Metoda uaktualniajaca linie autobusowa.
     * @param line
     */
    @Override
    public void updateLine(Line line) {
        currentSession().update(line);
    }

    /**
     * Metoda edytujaca linie autobusowa.
     * @param lineId
     * @return findLine(lineId)
     */
    @Override
    public Line editLine(int lineId) {
        return findLine(lineId);
    }

    /**
     * Metoda usuwajaca linie autobusowa.
     * @param lineId
     */
    @Override
    public void deleteLine(int lineId) {
        currentSession().delete(lineId);
    }

    /**
     * Metoda odnajdujaca linie autobusowa.
     * @param lineId
     * @return (Line)currentSession().get(Line.class, lineId)
     */
    @Override
    public Line findLine(int lineId) {
        return (Line)currentSession().get(Line.class, lineId);
    }

    /**
     * Metoda pobierajaca wszystkie linie autobusowe poprzez kolekcje List.
     * @return currentSession().createQuery("from Line").list()
     */
    @Override
    public List<Line> getAllLines() {
        return currentSession().createQuery("from Line").list();
    }
}
