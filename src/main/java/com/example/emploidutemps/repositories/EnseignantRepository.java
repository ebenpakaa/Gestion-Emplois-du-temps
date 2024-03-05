package com.example.emploidutemps.repositories;

import com.example.emploidutemps.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant ,Long> {

    List<Enseignant> findByNomContainingAndPrenomContainingAndTelContaining(String nom, String prenom, String tel);
}
