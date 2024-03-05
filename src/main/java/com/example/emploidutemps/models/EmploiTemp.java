package com.example.emploidutemps.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmploiTemp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Enseignant enseignant;
    @ManyToOne(fetch = FetchType.EAGER)
    private Matiere matiere;
    @ManyToOne(fetch = FetchType.EAGER)
    private Classe salle;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date heureDebut;
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date heureFin;

    public EmploiTemp(Long id, Enseignant enseignants, Classe classe, Matiere matiere) {
    }
}
