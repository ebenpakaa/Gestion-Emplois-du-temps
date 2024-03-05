package com.example.emploidutemps.controllers;

import com.example.emploidutemps.models.Matiere;
import com.example.emploidutemps.services.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matieres")
@AllArgsConstructor
public class MatiereController {

    private MatiereService matiereService;

    @GetMapping("/all")
    public ResponseEntity<List<Matiere>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(matiereService.findAll());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Matiere> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.matiereService.findById(id));
    }


    @PostMapping("/saveAll")
    public ResponseEntity<List<Matiere>> saveAll(@RequestBody List<Matiere> matieres) {
        return ResponseEntity.status(HttpStatus.OK).body(this.matiereService.findAll());
    }


    @PostMapping("/add")
    public Matiere save(@RequestBody Matiere matiere) throws Exception {
        return this.matiereService.save(matiere);
    }


    @PutMapping("/update")
    public ResponseEntity<Matiere> update(@RequestBody Matiere matiere) {
        return ResponseEntity.status(HttpStatus.OK).body(this.matiereService.update(matiere));
    }


    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody Matiere matiere) {
        return this.matiereService.delete(matiere);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteByid(@PathVariable Long id) {
        return this.matiereService.deleteByid(id);
    }
}
