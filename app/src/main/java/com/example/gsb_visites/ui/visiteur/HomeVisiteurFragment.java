package com.example.gsb_visites.ui.visiteur;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gsb_visites.R;
import com.example.gsb_visites.databinding.FragmentHomeVisiteurBinding;
import com.example.gsb_visites.databinding.FragmentLoginBinding;
import com.example.gsb_visites.viewmodel.VisiteurViewModel;


public class HomeVisiteurFragment extends Fragment {

    private FragmentHomeVisiteurBinding binding;
    private VisiteurViewModel visiteurViewModel;


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
        visiteurViewModel.getVisiteur().observe(getViewLifecycleOwner(), visiteur -> {
            if (visiteur != null) {
                binding.tvBonjour.setText("Bonjour " + visiteur.getNom());
            }
        });
    }
}