package com.example.emploidutemps.repositories;

import com.example.emploidutemps.models.Annee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneRepository extends JpaRepository<Annee,Long> {
}
