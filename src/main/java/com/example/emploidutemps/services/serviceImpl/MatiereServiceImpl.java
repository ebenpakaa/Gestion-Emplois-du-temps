package com.example.emploidutemps.services.serviceImpl;

import com.example.emploidutemps.models.Matiere;
import com.example.emploidutemps.repositories.MatiereRepository;
import com.example.emploidutemps.services.MatiereService;
import com.example.emploidutemps.services.baseService.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MatiereServiceImpl extends BaseServiceImpl<Matiere,Long> implements MatiereService {

    private MatiereRepository matiereRepository;
    @Override
    public JpaRepository<Matiere, Long> getRepository() {
        return matiereRepository;
    }

    @Override
    public List<Matiere> recherche(String code, String intitule) {
        return matiereRepository.findByCodeContainingAndIntituleContaining(code,intitule);
    }
}
