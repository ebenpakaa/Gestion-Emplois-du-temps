package com.example.emploidutemps.mapper;

import com.example.emploidutemps.dto.EmploiDTO;
import com.example.emploidutemps.models.EmploiTemp;


import java.util.function.Function;

public record EmploiDTOMapper() implements Function<EmploiTemp, EmploiDTO> {

    @Override
    public EmploiDTO apply(EmploiTemp emploi) {
        return new EmploiDTO(
                emploi.getId(),
                emploi.getEnseignant().getId(), // id_enseignant
                emploi.getMatiere().getId(), // id_cours
                emploi.getSalle().getId(), // id_classe
                emploi.getHeureDebut() , // dateDebut
                emploi.getHeureFin() // dateFin
        );
    }
}
