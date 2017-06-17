package pl.mzk.bielsko;

/**
 * Created by michal on 05.06.17.
 */

public class Przystanki
{
    private int id;
    private String ulica;
    private String nazwa;
    private int numerLini;
    private String kierunek;

    private Linie linia;

    public Linie getLinia() {
        return linia;
    }

    public void setLinia(Linie linia) {
        this.linia = linia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getNumerLini() {
        return numerLini;
    }

    public void setNumerLini(int numerLini) {
        this.numerLini = numerLini;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }
}