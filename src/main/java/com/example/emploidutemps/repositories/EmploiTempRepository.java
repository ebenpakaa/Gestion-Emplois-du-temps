package com.example.emploidutemps.repositories;

import com.example.emploidutemps.models.Classe;
import com.example.emploidutemps.models.EmploiTemp;
import com.example.emploidutemps.models.Enseignant;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmploiTempRepository extends JpaRepository<EmploiTemp,Long> {

    List<EmploiTemp> findByEnseignantAndHeureDebutAndHeureFin(Enseignant enseignant, Date heure_debut, Date heure_fin);

    List<EmploiTemp> findBySalleAndHeureDebutAndHeureFin(Classe salle, Date heure_debut, Date heure_fin);
}
