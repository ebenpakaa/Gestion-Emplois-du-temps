package com.example.emploidutemps.mapper;



import com.example.emploidutemps.dto.CoursDTO;
import com.example.emploidutemps.models.Cour;

import java.util.function.Function;

public record CoursMapper() implements Function<Cour, CoursDTO> {
    @Override
    public CoursDTO apply(Cour cours) {
        return new CoursDTO(
        cours.getId() ,
        cours.getMatiere().getId(),
        cours.getEnseignant().getId(),
        cours.getClasse().getId(),
        cours.getAnneeScolaire().getId()
        );
    }
}
