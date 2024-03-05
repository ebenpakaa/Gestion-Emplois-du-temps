package com.example.emploidutemps.services.serviceImpl;

import com.example.emploidutemps.models.Classe;
import com.example.emploidutemps.repositories.ClasseRepository;
import com.example.emploidutemps.services.ClasseService;
import com.example.emploidutemps.services.baseService.BaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClasseServiceImpl extends BaseServiceImpl<Classe,Long> implements ClasseService {

    private ClasseRepository classeRepository;

    @Override
    public JpaRepository<Classe, Long> getRepository() {
        return classeRepository;
    }
}
