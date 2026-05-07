package com.example.gsb_visites.data.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gsb_visites.data.model.Portefeuille;
import com.example.gsb_visites.data.network.GsbApi;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class PortefeuilleRepository {
    private final MutableLiveData<List<Portefeuille>> portefeuilleLiveData = new MutableLiveData<>(null);

    public LiveData<List<Portefeuille>> getPortefeuille() {
        return portefeuilleLiveData;
    }

    private final GsbApi gsbApi;

    @Inject
    public PortefeuilleRepository(GsbApi gsbApi) {
        this.gsbApi = gsbApi;
    }

    public LiveData<Boolean> loadPortefeuille(String visiteurId, String token) {
        MutableLiveData<Boolean> success = new MutableLiveData<>();

        Call<List<Portefeuille>> call = gsbApi.getPraticiensByVisiteurId(visiteurId, "Bearer " + token);
        call.enqueue(new Callback<List<Portefeuille>>() {
            @Override
            public void onResponse(Call<List<Portefeuille>> call, Response<List<Portefeuille>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    portefeuilleLiveData.setValue(response.body());
                    success.postValue(true);
                } else {
                    success.postValue(false);
                }
            }

            @Override
            public void onFailure(Call<List<Portefeuille>> call, Throwable throwable) {
                success.postValue(false);
            }
        });
        return success;
    }
}