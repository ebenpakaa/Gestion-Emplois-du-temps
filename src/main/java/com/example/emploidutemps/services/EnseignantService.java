package com.example.emploidutemps.services;

import com.example.emploidutemps.models.Enseignant;
import com.example.emploidutemps.services.baseService.BaseServiceInterface;

import java.util.List;

public interface EnseignantService extends BaseServiceInterface<Enseignant,Long> {

    List<Enseignant> recherche(String nom, String prenom, String tel);
}
