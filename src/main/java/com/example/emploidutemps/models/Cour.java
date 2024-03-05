package com.example.emploidutemps.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @ManyToOne
    @JoinColumn(name = "matiere_id",referencedColumnName = "id")
    private Matiere matiere ;

    @ManyToOne
    @JoinColumn(name = "enseignant_id",referencedColumnName = "id")
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "classe_id",referencedColumnName = "id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "annee_scolaire_id",referencedColumnName = "id")
    private Annee anneeScolaire;

}
