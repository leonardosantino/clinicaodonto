package com.clinicaodonto.controller;

import com.clinicaodonto.model.PatientModel;
import com.clinicaodonto.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping("/save")
    public ResponseEntity<PatientModel> save(@RequestBody PatientModel patientModel){
        return ResponseEntity.ok(service.save(patientModel));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PatientModel>> selectAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
