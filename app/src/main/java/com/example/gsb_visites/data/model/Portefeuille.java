package com.example.gsb_visites.data.model;

import java.io.Serializable;

public class Portefeuille implements Serializable {

    private String dateDebutSuivi;
    private Praticien praticien;
    private String visiteur;

    public String getDateDebutSuivi() { return dateDebutSuivi; }
    public Praticien getPraticien() { return praticien; }
    public String getVisiteur() { return visiteur; }
}
