package com.example.emploidutemps.controllers;

import com.example.emploidutemps.dto.CoursDTO;
import com.example.emploidutemps.models.Cour;
import com.example.emploidutemps.services.CourService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
@AllArgsConstructor
public class CourController {
    private CourService courService;

    @GetMapping("/all")
    public ResponseEntity<List<Cour>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(courService.findAll());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<Cour> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.courService.findById(id));
    }


    @PostMapping("/saveAll")
    public ResponseEntity<List<Cour>> saveAll(@RequestBody List<Cour> cours) {
        return ResponseEntity.status(HttpStatus.OK).body(this.courService.findAll());
    }


    @PostMapping("/add")
    public CoursDTO save(@RequestBody CoursDTO cour) throws Exception {
        return this.courService.save(cour);
    }


    @PutMapping("/update")
    public ResponseEntity<Cour> update(@RequestBody Cour cour) {
        return ResponseEntity.status(HttpStatus.OK).body(this.courService.update(cour));
    }


    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody Cour cour) {
        return this.courService.delete(cour);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteByid(@PathVariable Long id) {
        return this.courService.deleteByid(id);
    }
}
