package io.github.eperatis.model;

import io.github.eperatis.exceptions.FontossagNemLehetKisebb;
import io.github.eperatis.exceptions.FontossagNemLehetNagyobb;
import io.github.eperatis.exceptions.NevNemLehetUresException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Note {
    private String id;
    private String nev;
    private LocalDate hozzaAdasDatuma;
    private Kategoria kategoria;
    private int fontossag;
    private List<Jegyzet> jegyzetek;

    public Note() {
        this.id = UUID.randomUUID().toString();
        this.hozzaAdasDatuma = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) throws NevNemLehetUresException {
        if(nev.trim().length()==0){
            throw new NevNemLehetUresException();
        }
        this.nev = nev;
    }

    public LocalDate getHozzaAdasDatuma() {
        return hozzaAdasDatuma;
    }

    public void setHozzaAdasDatuma(LocalDate hozzaAdasDatuma) {
        this.hozzaAdasDatuma = hozzaAdasDatuma;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    public int getFontossag() {
        return fontossag;
    }

    public void setFontossag(int fontossag) throws FontossagNemLehetKisebb, FontossagNemLehetNagyobb {
        if(fontossag < 0){
            throw new FontossagNemLehetKisebb("Fontosság nem lehet kisebb mint 0!");
        }
        if(fontossag > 10){
            throw new FontossagNemLehetNagyobb("Fontosság nem lehet nagyobb mint 10!");
        }
        this.fontossag = fontossag;
    }

    public List<Jegyzet> getJegyzetek() {
        return jegyzetek;
    }

    public void setJegyzetek(List<Jegyzet> jegyzetek) {
        this.jegyzetek = jegyzetek;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", nev='" + nev + '\'' +
                ", hozzaAdasDatuma=" + hozzaAdasDatuma +
                ", kategoria=" + kategoria +
                ", fontossag=" + fontossag +
                ", jegyzetek=" + jegyzetek +
                '}';
    }
}
