package com.example.gsb_visites.data.repository;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gsb_visites.data.model.Visiteur;
import com.example.gsb_visites.data.model.Praticien;
import com.example.gsb_visites.data.network.GsbApi;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Singleton
public class PraticienRepository {
    private static final String TAG = "PraticienRepository";
    private final MutableLiveData<Praticien> praticienLiveData = new MutableLiveData<>(null);
    private final MutableLiveData<List<Praticien>> praticienListLiveData = new MutableLiveData<>();
    private final GsbApi gsbApi;

    @Inject
    public PraticienRepository(GsbApi gsbApi) {
        this.gsbApi = gsbApi;
    }

    public LiveData<Praticien> getPraticien() {
        return praticienLiveData;
    }

    public LiveData<List<Praticien>> getAllPraticiens() {
        Call<List<Praticien>> call = gsbApi.getAllPraticiens();
        call.enqueue(new Callback<List<Praticien>>() {
            @Override
            public void onResponse(Call<List<Praticien>> call, Response<List<Praticien>> response) {
                if (response.isSuccessful()) {
                    praticienListLiveData.setValue(response.body());
                    Log.d(TAG, "Récupération des praticiens réussie");
                } else {
                    Log.e(TAG, "Réponse non-réussie: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Praticien>> call, Throwable t) {
                Log.e(TAG, "Erreur lors de la récupération des praticiens", t);
            }
        });
        return praticienListLiveData;
    }
}
