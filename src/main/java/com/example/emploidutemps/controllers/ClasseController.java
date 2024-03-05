package com.example.emploidutemps.controllers;

import com.example.emploidutemps.models.Classe;
import com.example.emploidutemps.services.ClasseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class ClasseController {

    private ClasseService classeService;

    @GetMapping("/all")
    public ResponseEntity<List<Classe>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(classeService.findAll());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Classe> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.classeService.findById(id));
    }


    @PostMapping("/saveAll")
    public ResponseEntity<List<Classe>> saveAll(@RequestBody List<Classe> entities) {
        return ResponseEntity.status(HttpStatus.OK).body(this.classeService.findAll());
    }


    @PostMapping("/add")
    public Classe save(@RequestBody Classe classe) throws Exception {
        return this.classeService.save(classe);
    }


    @PutMapping("/update")
    public ResponseEntity<Classe> update(@RequestBody Classe classe) {
        return ResponseEntity.status(HttpStatus.OK).body(this.classeService.update(classe));
    }


    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody Classe classe) {
        return this.classeService.delete(classe);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteByid(@PathVariable Long id) {
        return this.classeService.deleteByid(id);
    }
}
