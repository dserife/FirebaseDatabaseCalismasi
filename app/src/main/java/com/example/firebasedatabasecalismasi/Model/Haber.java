package com.example.firebasedatabasecalismasi.Model;

public class Haber {

    private String haberBaslik;
    private String haberIcerik;
    int haberResim;

    public Haber() {
    }

    public Haber(String haberBaslik, String haberIcerik, int haberResim) {
        this.haberBaslik = haberBaslik;
        this.haberIcerik = haberIcerik;
        this.haberResim = haberResim;
    }

    public String getHaberBaslik() {
        return haberBaslik;
    }

    public void setHaberBaslik(String haberBaslik) {
        this.haberBaslik = haberBaslik;
    }

    public String getHaberIcerik() {
        return haberIcerik;
    }

    public void setHaberIcerik(String haberIcerik) {
        this.haberIcerik = haberIcerik;
    }

    public int getHaberResim() {
        return haberResim;
    }

    public void setHaberResim(int haberResim) {
        this.haberResim = haberResim;
    }
}
