package com.example.gsb_visites.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Visiteur implements Serializable {

    @SerializedName("_id")
    private String id;
    @SerializedName("nom")
    private String nom;
    @SerializedName("prenom")
    private String prenom;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String mdp;
    @SerializedName("token")
    private String token;
    private ArrayList<Praticien> praticiens;



    public Visiteur(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public Visiteur(String nom, String prenom, String email, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
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
    public String getMdp() {
        return mdp;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }


}
