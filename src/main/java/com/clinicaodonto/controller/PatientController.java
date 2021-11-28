package com.clinicaodonto.controller;

import com.clinicaodonto.model.PatientModel;
import com.clinicaodonto.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository repository;

    @PostMapping("/save")
    public ResponseEntity<PatientModel> save(@RequestBody PatientModel patientModel){
        return ResponseEntity.ok(repository.save(patientModel));
    }

    @GetMapping("/selectall")
    public ResponseEntity<List<PatientModel>> selectAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
