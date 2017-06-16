package pl.mzk.bielsko;

/**
 * Created by michal on 16.06.17.
 */

public class Przystanki
{
    private int id;
    private String ulica;
    private String nazwa;
    private int numer_linii;
    private String kierunek;

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

    public int getNumer_linii() {
        return numer_linii;
    }

    public void setNumer_linii(int numer_linii) {
        this.numer_linii = numer_linii;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }
}