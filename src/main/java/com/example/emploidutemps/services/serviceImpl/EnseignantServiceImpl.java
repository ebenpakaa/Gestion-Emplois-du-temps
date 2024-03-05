package com.example.emploidutemps.services.serviceImpl;

import com.example.emploidutemps.models.Enseignant;
import com.example.emploidutemps.repositories.EnseignantRepository;
import com.example.emploidutemps.services.EnseignantService;
import com.example.emploidutemps.services.baseService.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnseignantServiceImpl extends BaseServiceImpl<Enseignant,Long> implements EnseignantService {

    private EnseignantRepository enseignantRepository;
    @Override
    public JpaRepository<Enseignant, Long> getRepository() {
        return enseignantRepository;
    }

    @Override
    public List<Enseignant> recherche(String nom, String prenom, String tel) {
        return enseignantRepository.findByNomContainingAndPrenomContainingAndTelContaining(nom,prenom,tel);
    }
}
