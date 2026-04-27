package com.example.gsb_visites.data.repository;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gsb_visites.data.model.Visiteur;
import com.example.gsb_visites.data.network.GsbApi;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class VisiteurRepository {
    private static final String TAG = "VisiteurRepository";
    private final MutableLiveData<Visiteur> visiteurLiveData = new MutableLiveData<>(null);
    private final GsbApi gsbApi;

    @Inject
    public VisiteurRepository(GsbApi gsbApi) {
        this.gsbApi = gsbApi;
    }

    public LiveData<Visiteur> getVisiteur() {
        return visiteurLiveData;
    }

    public LiveData<Boolean> login(String email, String password) {
        MutableLiveData<Boolean> success = new MutableLiveData<>();

        try {
            Call<Visiteur> call = gsbApi.login(new Visiteur(email, password));
            call.enqueue(new Callback<Visiteur>() {
                @Override
                public void onResponse(Call<Visiteur> call, Response<Visiteur> response) {
                    try {
                        Visiteur visiteur = response.body();
                        if (response.isSuccessful()) {
                             visiteur = response.body();
                            String token = visiteur.getToken();
                            visiteur.setToken(token);
                            visiteurLiveData.setValue(visiteur);
                            success.setValue(true);
                            Log.d(TAG, "Login réussi");
                        } else {
                            Log.e(TAG, "Réponse non-réussie: " + response.code());
                            success.setValue(false);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Erreur dans onResponse", e);
                        success.setValue(false);
                    }
                }

                @Override
                public void onFailure(Call<Visiteur> call, Throwable t) {
                    Log.e(TAG, "Erreur réseau", t);
                    success.setValue(false);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Erreur lors de l'appel login", e);
            success.setValue(false);
        }

        return success;
    }

    public void logout() {
        visiteurLiveData.setValue(null);
    }
}
