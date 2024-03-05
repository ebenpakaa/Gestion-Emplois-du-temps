package com.example.emploidutemps.controllers;

import com.example.emploidutemps.dto.EmploiDTO;
import com.example.emploidutemps.models.EmploiTemp;
import com.example.emploidutemps.services.EmploiTempService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emploi_temps")
@AllArgsConstructor
public class EmploiTempController {

    private EmploiTempService emploiTempService;

    @GetMapping("/all")
    public ResponseEntity<List<EmploiTemp>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(emploiTempService.findAll());
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<EmploiTemp> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.emploiTempService.findById(id));
    }


    @PostMapping("/saveAll")
    public ResponseEntity<List<EmploiTemp>> saveAll(@RequestBody List<EmploiTemp> emploiTemps) {
        return ResponseEntity.status(HttpStatus.OK).body(this.emploiTempService.findAll());
    }


    @PostMapping("/add")
    public EmploiTemp save(@RequestBody EmploiDTO emploiTemp) throws Exception {
        return this.emploiTempService.save(emploiTemp);
    }


    @PutMapping("/update")
    public ResponseEntity<EmploiTemp> update(@RequestBody EmploiTemp emploiTemp) {
        return ResponseEntity.status(HttpStatus.OK).body(this.emploiTempService.update(emploiTemp));
    }


    @DeleteMapping("/delete")
    public Boolean delete(@RequestBody EmploiTemp emploiTemp) {
        return this.emploiTempService.delete(emploiTemp);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteByid(@PathVariable Long id) {
        return this.emploiTempService.deleteByid(id);
    }
}
