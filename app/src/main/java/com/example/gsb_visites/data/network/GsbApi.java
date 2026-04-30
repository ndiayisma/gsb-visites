package com.example.gsb_visites.data.network;


import com.example.gsb_visites.data.model.Praticien;
import com.example.gsb_visites.data.model.Visiteur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GsbApi {
    @POST("/api/visiteurs/connexion")
    Call<Visiteur> login(@Body Visiteur visiteur);

    @GET("api/visiteurs/{id}")
    Call<Visiteur> GetVisiteurById(
            @retrofit2.http.Path("id") String id,
            @retrofit2.http.Header("Authorization") String token);

    @GET("api/praticiens")
    Call<List<Praticien>> getAllPraticiens();

    @GET("api/visiteurs/{id}/portefeuille")
    Call <List<Visiteur>> getPraticiensByVisiteurId(
            @retrofit2.http.Path("id") String visiteurId,
            @retrofit2.http.Header("Authorization") String token);


}