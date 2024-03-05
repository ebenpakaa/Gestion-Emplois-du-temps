package com.example.emploidutemps.services.serviceImpl;


import com.example.emploidutemps.dto.CoursDTO;
import com.example.emploidutemps.models.*;
import com.example.emploidutemps.repositories.*;
import com.example.emploidutemps.services.CourService;
import com.example.emploidutemps.services.baseService.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourServiceImpl extends BaseServiceImpl<Cour,Long> implements CourService {

   private CourRepository courRepository;
   private MatiereRepository matiereRepository;
   private EnseignantRepository enseignantRepository;
   private ClasseRepository classeRepository;
   private AnneRepository anneRepository;

    @Override
    public JpaRepository<Cour, Long> getRepository() {
        return courRepository;
    }

    public CoursDTO save(CoursDTO coursDTO){
        Long id = coursDTO.id() ;

        Long  matiere_id = coursDTO.id_matiere();
        Matiere matiere =matiereRepository.findById(matiere_id).orElse(null);

        Long enseignant_id = coursDTO.id_enseignant();
        Enseignant enseignant = enseignantRepository.findById(enseignant_id).orElse(null);

        Long classe_id = coursDTO.id_classe();
        Classe classe = classeRepository.findById(classe_id).orElse(null);

        Long annee_scolaire_id = coursDTO.id_annee_scolaire() ;

        Annee anneeScolaire = anneRepository.findById(annee_scolaire_id).orElse(null);

        Cour cours = new Cour(id ,matiere ,enseignant ,classe ,anneeScolaire);
        this.courRepository.save(cours);
        return coursDTO;

    }


}
