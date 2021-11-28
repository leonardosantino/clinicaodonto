package com.clinicaodonto.controller;

import com.clinicaodonto.model.DentistModel;
import com.clinicaodonto.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    @Autowired
    private DentistService service;

    @PostMapping("/save")
    public ResponseEntity<DentistModel> save(@RequestBody DentistModel dentistModel){
        return ResponseEntity.ok(service.save(dentistModel));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DentistModel>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }
}