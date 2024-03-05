package com.example.emploidutemps.repositories;

import com.example.emploidutemps.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Long> {

    List<Matiere> findByCodeContainingAndIntituleContaining(String code, String intitule);
}
