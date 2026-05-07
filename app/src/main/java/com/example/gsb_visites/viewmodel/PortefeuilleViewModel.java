package com.example.gsb_visites.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.gsb_visites.data.model.Portefeuille;
import com.example.gsb_visites.data.repository.PortefeuilleRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PortefeuilleViewModel extends ViewModel {
    private final PortefeuilleRepository portefeuilleRepository;

    @Inject
    public PortefeuilleViewModel(PortefeuilleRepository portefeuilleRepository) {
        this.portefeuilleRepository = portefeuilleRepository;
    }

    public LiveData<Boolean> loadPortefeuille(String visiteurId, String token) {
        return portefeuilleRepository.loadPortefeuille(visiteurId, token);
    }

    public LiveData<List<Portefeuille>> getPortefeuille() {
        return portefeuilleRepository.getPortefeuille();
    }
}
