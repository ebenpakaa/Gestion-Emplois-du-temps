package com.example.emploidutemps.repositories;

import com.example.emploidutemps.models.Cour;
import com.example.emploidutemps.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CourRepository extends JpaRepository<Cour,Long> {

//    @Query("SELECT c FROM Cour c WHERE c.enseignant = :enseignant AND c.heure_debut = :heure AND c.heure_fin = :heure")
//    Cour getCourByEnseignantAndHeure(Enseignant enseignant, Date heure);
}
