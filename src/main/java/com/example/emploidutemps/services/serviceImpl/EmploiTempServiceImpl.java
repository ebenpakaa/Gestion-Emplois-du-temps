package com.example.emploidutemps.services.serviceImpl;

import com.example.emploidutemps.dto.EmploiDTO;
import com.example.emploidutemps.models.Classe;
import com.example.emploidutemps.models.EmploiTemp;
import com.example.emploidutemps.models.Enseignant;
import com.example.emploidutemps.models.Matiere;
import com.example.emploidutemps.repositories.*;
import com.example.emploidutemps.services.EmploiTempService;
import com.example.emploidutemps.services.baseService.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmploiTempServiceImpl extends BaseServiceImpl<EmploiTemp,Long> implements EmploiTempService {

     private EmploiTempRepository emploiTempRepository;
    private MatiereRepository matiereRepository;
    private EnseignantRepository enseignantRepository;
    private ClasseRepository classeRepository;
    @Override
    public JpaRepository<EmploiTemp, Long> getRepository() {
        return emploiTempRepository;
    }

    public EmploiTemp save(EmploiDTO emploiTemp){

        Long id = emploiTemp.id();
        Long enseignant = emploiTemp.id_enseignant();
        Enseignant enseignants = enseignantRepository.findById(enseignant).orElse(null);

        Long salle = emploiTemp.id_salle();
        Classe classe = classeRepository.findById(salle).orElse(null);

        Long matieres = emploiTemp.id_matiere();
        Matiere matiere =matiereRepository.findById(matieres).orElse(null);

        EmploiTemp emploi = new EmploiTemp(id, enseignants,classe,matiere);
        if (emploisTempExistForEnseignantAtSameHour(emploi)){
            throw new IllegalArgumentException("Un emploi du temps pour cet enseignant à cette heure existe déjà.");
        }else if(emploisTempExistAtSameHourAndSalle(emploi)){
            throw new IllegalArgumentException("Un emploi du temps existe déjà pour cette salle à cette heure.");
        }

        return emploiTempRepository.save(emploi);
    }

    public boolean emploisTempExistForEnseignantAtSameHour(EmploiTemp emploiTemp){
        List<EmploiTemp> emploiTemp1=emploiTempRepository.findByEnseignantAndHeureDebutAndHeureFin(emploiTemp.getEnseignant(), emploiTemp.getHeureDebut(),emploiTemp.getHeureFin());
        return !emploiTemp1.isEmpty();
    }

    public boolean emploisTempExistAtSameHourAndSalle(EmploiTemp emploiTemp){
        List<EmploiTemp> emploiTemp2 = emploiTempRepository.findBySalleAndHeureDebutAndHeureFin(emploiTemp.getSalle(), emploiTemp.getHeureDebut(),emploiTemp.getHeureFin());
        return emploiTemp2.isEmpty();
    }
}
