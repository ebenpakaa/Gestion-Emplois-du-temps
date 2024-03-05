package com.example.emploidutemps.controllers;

import com.example.emploidutemps.models.Annee;
import com.example.emploidutemps.services.AnneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annees")
@AllArgsConstructor
public class AnneController {

    private AnneService anneeService;

    @GetMapping("/all")
    public ResponseEntity<List<Annee>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(anneeService.findAll());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Annee> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.anneeService.findById(id));
    }


    @PostMapping("/saveAll")
    public ResponseEntity<List<Annee>> saveAll(@RequestBody List<Annee> annees) {
        return ResponseEntity.status(HttpStatus.OK).body(this.anneeService.findAll());
    }


    @PostMapping("/add")
    public Annee save(@RequestBody Annee annee) throws Exception {
        return this.anneeService.save(annee);
    }


    @PutMapping("/update")
    public ResponseEntity<Annee> update(@RequestBody Annee annee) {
        return ResponseEntity.status(HttpStatus.OK).body(this.anneeService.update(annee));
    }


    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody Annee annee) {
        return this.anneeService.delete(annee);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteByid(@PathVariable Long id) {
        return this.anneeService.deleteByid(id);
    }
}
