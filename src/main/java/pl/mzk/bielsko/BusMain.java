package pl.mzk.bielsko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by michal on 05.06.17.
 */
public class BusMain
{
    public static void main(String[] args)
    {
        Configuration conf = new Configuration().configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session s = factory.openSession();

        //List n = s.createQuery("SELECT n.numer_linii from Linie n").list();
        //List r = s.createQuery("SELECT r.relacja from Linie r").list();
        //List k = s.createQuery("SELECT k.kierunek from Linie k").list();
        //s.createQuery("DELETE Linie l WHERE l.id = 1 ").executeUpdate();
        //System.out.println(n.size() + r.size() + k.size());

        Transaction t = s.beginTransaction();
        Linie linia = new Linie();
        linia.setId(1);
        linia.setNumer_lini(1);
        linia.setRelacja("Osiedle Beskidzkie - Cygański Las");
        linia.setKierunek("Cygański Las");
        Set<Przystanki> zbior = new HashSet<Przystanki>();
        Przystanki przystanki = new Przystanki();
        przystanki.setId(1);
        przystanki.setKierunek("Cygański Las");
        przystanki.setLinia(linia);
        zbior.add(przystanki);
        linia.setPrzystanki(zbior);

        s.persist(linia);
        t.commit();

        //Linie linie = (Linie) s.get(Linie.class, 1 );
        //System.out.println(linie.getId());
    }
}
