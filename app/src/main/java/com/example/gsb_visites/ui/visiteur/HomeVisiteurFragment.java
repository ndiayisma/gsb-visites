package com.example.gsb_visites.ui.visiteur;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gsb_visites.R;
import com.example.gsb_visites.viewmodel.PortefeuilleViewModel;
import com.example.gsb_visites.data.model.Praticien;
import com.example.gsb_visites.data.model.Visiteur;
import com.example.gsb_visites.databinding.FragmentHomeVisiteurBinding;
import com.example.gsb_visites.databinding.FragmentLoginBinding;
import com.example.gsb_visites.viewmodel.VisiteurViewModel;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class HomeVisiteurFragment extends Fragment {

    private FragmentHomeVisiteurBinding binding;
    private VisiteurViewModel visiteurViewModel;
    private Visiteur visiteur;
    private Praticien praticien;
    private PortefeuilleViewModel portefeuilleViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeVisiteurBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        visiteurViewModel = new ViewModelProvider(requireActivity()).get(VisiteurViewModel.class);
        portefeuilleViewModel = new ViewModelProvider(requireActivity()).get(PortefeuilleViewModel.class);

        // Afficher le nom du visiteur
        visiteurViewModel.getVisiteur().observe(getViewLifecycleOwner(), visiteur -> {
            if (visiteur != null) {
                binding.tvBonjour.setText("Bonjour " + visiteur.getNom() + " " + visiteur.getPrenom() + " !");
                portefeuilleViewModel.loadPortefeuille(visiteur.getId(), visiteur.getToken());
            }
        });

        // Observe la liste du portefeuille (praticiens suivis)
        portefeuilleViewModel.getPortefeuille().observe(getViewLifecycleOwner(), portefeuilles -> {
            if (portefeuilles != null) {
                // alimenter le recyclerView
                binding.tvBonjour.append("\nPraticiens suivis : " + portefeuilles.size());
            }
        });
    }
}