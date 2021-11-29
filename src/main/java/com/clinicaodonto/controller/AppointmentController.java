package com.clinicaodonto.controller;

import com.clinicaodonto.model.AppointmentModel;
import com.clinicaodonto.model.DentistModel;
import com.clinicaodonto.service.AppointementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointementService service;

    // SAVE
    @PostMapping
    public ResponseEntity<AppointmentModel> save(@RequestBody AppointmentModel appointmentModel){
        return ResponseEntity.ok(service.save(appointmentModel));
    }

    // EDIT
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentModel> editById(@PathVariable Integer id, @RequestBody AppointmentModel appointmentModel){
        return ResponseEntity.ok(service.editById(id, appointmentModel));
    }

    // GET By ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AppointmentModel>> getById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getById(id));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<AppointmentModel>> selectAll(){
        return ResponseEntity.ok(service.findAll());
    }
}