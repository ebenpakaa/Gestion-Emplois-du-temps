package com.example.emploidutemps.services;

import com.example.emploidutemps.models.Matiere;
import com.example.emploidutemps.services.baseService.BaseServiceInterface;

import java.util.List;

public interface MatiereService extends BaseServiceInterface<Matiere,Long> {

    List<Matiere> recherche(String code, String intitule);
}
