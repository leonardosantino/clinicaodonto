package com.clinicaodonto.controller;

import com.clinicaodonto.model.DentistModel;
import com.clinicaodonto.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService service;

    // SAVE
    @PostMapping
    public ResponseEntity<DentistModel> save(@RequestBody DentistModel dentistModel){
        return ResponseEntity.ok(service.save(dentistModel));
    }

    // EDIT
    @PutMapping("/{id}")
    public ResponseEntity<DentistModel> editById(@PathVariable Integer id, @RequestBody DentistModel dentistModel){
        return ResponseEntity.ok(service.editById(id, dentistModel));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(service.deleteById(id));
    }

    // GET By ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<DentistModel>> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<DentistModel>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}