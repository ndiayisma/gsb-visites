package com.example.gsb_visites.ui.visiteur;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gsb_visites.R;
import com.example.gsb_visites.data.model.Visiteur;
import com.example.gsb_visites.databinding.FragmentLoginBinding;
import com.example.gsb_visites.viewmodel.VisiteurViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private VisiteurViewModel visiteurViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        visiteurViewModel = new ViewModelProvider(requireActivity()).get(VisiteurViewModel.class);

        binding.btnLogin.setOnClickListener(v -> {
            String email    = binding.etEmail.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();

            visiteurViewModel.login(email, password).observe(getViewLifecycleOwner(), success -> {

                if (success) {
                    Visiteur visiteur = visiteurViewModel.getVisiteur().getValue();
                    if (visiteur != null) {
                        String token = visiteur.getToken();
                        Toast.makeText(getContext(), "Connecté ! Token : " + token, Toast.LENGTH_SHORT).show();
                        NavDirections action = LoginFragmentDirections.actionLoginFragmentToHomeVisiteurFragment();
                        NavHostFragment.findNavController(LoginFragment.this).navigate(action);
                    }
                } else {
                    Toast.makeText(getContext(), "Identifiants invalides", Toast.LENGTH_SHORT).show();
                }
            });

        });
    }
}