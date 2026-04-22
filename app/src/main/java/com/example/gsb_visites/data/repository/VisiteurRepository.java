package com.example.gsb_visites.data.repository;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gsb_visites.data.model.Visiteur;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class VisiteurRepository {
    private final MutableLiveData<Visiteur> visiteurLiveData = new MutableLiveData<>(null);

    @Inject
    public VisiteurRepository() { }

    public LiveData<Visiteur> getVisiteur() {
        return visiteurLiveData;
    }

    public LiveData<Boolean> login(String email, String password) {
        MutableLiveData<Boolean> success = new MutableLiveData<>();

        if ("visiteur@test.com".equals(email) && "1234".equals(password)) {
            Visiteur visiteur = new Visiteur(email, password);
            visiteur.setToken("fake-jwt-token-abc123");
            visiteurLiveData.setValue(visiteur);
            success.setValue(true);
        } else {
            success.setValue(false);
        }

        return success;
    }

    public void logout() {
        visiteurLiveData.setValue(null);
    }
}

