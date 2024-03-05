package com.example.emploidutemps.controllers;

import com.example.emploidutemps.models.Enseignant;
import com.example.emploidutemps.services.EnseignantService;
import com.example.emploidutemps.services.serviceImpl.EnseignantServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseigants")
@AllArgsConstructor
public class EnseignantController {

    private EnseignantService enseignantService;

    @GetMapping("/all")
    public ResponseEntity<List<Enseignant>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enseignantService.findAll());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Enseignant> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.enseignantService.findById(id));
    }


    @PostMapping("/saveAll")
    public ResponseEntity<List<Enseignant>> saveAll(@RequestBody List<Enseignant> entities) {
        return ResponseEntity.status(HttpStatus.OK).body(this.enseignantService.findAll());
    }


    @PostMapping("/add")
    public Enseignant save(@RequestBody Enseignant enseignant) throws Exception {
        return this.enseignantService.save(enseignant);
    }


    @PutMapping("/update")
    public ResponseEntity<Enseignant> update(@RequestBody Enseignant enseignant) {
        return ResponseEntity.status(HttpStatus.OK).body(this.enseignantService.update(enseignant));
    }


    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody Enseignant enseignant) {
        return this.enseignantService.delete(enseignant);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteById(@PathVariable Long id) {
        return this.enseignantService.deleteByid(id);
    }


    @GetMapping("/recherche")
    public List<Enseignant> recherche(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) String tel
    ) {
        return enseignantService.recherche(nom, prenom, tel);
    }


}
