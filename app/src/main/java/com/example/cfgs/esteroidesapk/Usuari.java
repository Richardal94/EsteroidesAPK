package com.example.cfgs.esteroidesapk;

import java.util.Iterator;
import java.util.Objects;

public class Usuari implements Comparable<Usuari>{
    private String nom;
    private int puntuacio;

    public Usuari(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio = puntuacio;
    }

    public Usuari(String nom) {
        this.nom = nom;
        this.puntuacio = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    @Override

    public int compareTo(Usuari o) {
        return o.getPuntuacio() - this.getPuntuacio();
    }


    @Override
    public int hashCode() {

        return Objects.hash(puntuacio);
    }

    @Override

    public boolean equals(Object obj) {

        if (obj == null) {   return false;  }

        if (getClass() != obj.getClass()) {  return false;   }

        final Usuari other = (Usuari) obj;

        if (!Objects.equals(this.getNom(), other.getNom())) {    return false;     }

        return true;

    }

}
