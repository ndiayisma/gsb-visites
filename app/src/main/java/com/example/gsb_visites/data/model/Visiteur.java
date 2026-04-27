package com.example.gsb_visites.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Visiteur implements Serializable {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String mdp;
    private String token;


    public Visiteur(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
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

}
