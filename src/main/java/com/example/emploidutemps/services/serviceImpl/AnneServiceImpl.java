package com.example.emploidutemps.services.serviceImpl;

import com.example.emploidutemps.models.Annee;
import com.example.emploidutemps.repositories.AnneRepository;
import com.example.emploidutemps.services.AnneService;
import com.example.emploidutemps.services.baseService.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnneServiceImpl extends BaseServiceImpl<Annee,Long> implements AnneService {
     private AnneRepository anneRepository;

    @Override
    public JpaRepository<Annee, Long> getRepository() {
        return anneRepository;
    }
}
