package com.example.emploidutemps.dto;

import java.util.Date;

public record EmploiDTO(
        Long id ,
        Long id_enseignant,

        Long id_matiere,

        Long id_salle,

        Date HeureDebut ,

        Date HeureFin

        ) {
}
