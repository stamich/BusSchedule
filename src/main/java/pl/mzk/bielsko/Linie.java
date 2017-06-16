package pl.mzk.bielsko;

import java.util.Set;

/**
 * Created by michal on 05.06.17.
 */

public class Linie
{
    private int id;
    private int numer_lini;
    private String relacja;
    private String kierunek;
    private Set<Przystanki> przystanek;

    public Set<Przystanki> getPrzystanki()
    {
        return przystanek;
    }

    public void setPrzystanki(Set<Przystanki> przystanki)
    {
        this.przystanek = przystanki;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getNumer_lini()
    {
        return numer_lini;
    }

    public void setNumer_lini(int numer_lini)
    {
        this.numer_lini = numer_lini;
    }

    public String getRelacja()
    {
        return relacja;
    }

    public void setRelacja(String relacja)
    {
        this.relacja = relacja;
    }

    public String getKierunek()
    {
        return kierunek;
    }

    public void setKierunek(String kierunek)
    {
        this.kierunek = kierunek;
    }
}
