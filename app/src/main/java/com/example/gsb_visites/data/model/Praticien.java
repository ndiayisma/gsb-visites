package com.example.gsb_visites.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Praticien implements Serializable {
    @SerializedName("nom")
    private String nom;
    @SerializedName("prenom")
    private String prenom;
    @SerializedName("email")
    private String email;
    @SerializedName("rue")
    private String rue;
    @SerializedName("codePostal")
    private String codePostal;
    @SerializedName("ville")
    private String ville;

    public Praticien(String nom, String prenom, String email, String rue, String codePostal, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getRue() {
        return rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }


}
