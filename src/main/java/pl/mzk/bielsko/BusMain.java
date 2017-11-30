package pl.mzk.bielsko;

/**
 * Created by michal on 05.06.17.
 */

public class BusMain
{
    /*public static void main(String[] args)
    {
        Configuration conf = new Configuration().configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session s = factory.openSession();

        List n = s.createQuery("SELECT n.numerLini from Lines n").list();
        List r = s.createQuery("SELECT r.relacja from Lines r").list();
        List k = s.createQuery("SELECT k.kierunek from Lines k").list();
        //s.createQuery("DELETE Lines l WHERE l.id = 1 ").executeUpdate();
        System.out.println(n.size() + r.size() + k.size());

        Transaction t = s.beginTransaction();
        Lines linia = new Lines();
        /*linia.setId(1);
        linia.setNumerLini(1);
        linia.setRelacja("Osiedle Beskidzkie - Cygański Las");
        linia.setKierunek("Cygański Las");
        Set<Stops> zbior = new HashSet<Stops>();
        Stops przystanki = new Stops();
        przystanki.setId(1);
        przystanki.setKierunek("Cygański Las");
        przystanki.setLinia(linia);
        zbior.add(przystanki);
        linia.setPrzystanki(zbior); //

        //s.persist(linia);
        //t.commit();

        //Lines linie = (Lines) s.get(Lines.class, 1 );
        //System.out.println(linie.getId());
    }*/
}
