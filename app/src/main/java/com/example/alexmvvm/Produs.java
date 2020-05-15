package com.example.alexmvvm;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "produse")
public class Produs {

    @PrimaryKey(autoGenerate = true)
    private int produsId;

    private String titlu;

    private String descriere;

    private double pret;

    public Produs(String titlu, String descriere, double pret) {
        this.titlu = titlu;
        this.descriere = descriere;
        this.pret = pret;
    }

    public int getProdusId() {
        return produsId;
    }

    public void setProdusId(int produsId) {
        this.produsId = produsId;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }
}
