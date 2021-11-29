package com.clinicaodonto.controller;

import com.clinicaodonto.model.DentistModel;
import com.clinicaodonto.model.PatientModel;
import com.clinicaodonto.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public ResponseEntity<PatientModel> save(@RequestBody PatientModel patientModel){
        return ResponseEntity.ok(service.save(patientModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> editById(@PathVariable Integer id, @RequestBody PatientModel patientModel){
        return ResponseEntity.ok(service.editById(id, patientModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PatientModel>> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<PatientModel>> selectAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
