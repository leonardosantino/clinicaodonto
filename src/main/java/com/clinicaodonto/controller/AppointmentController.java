package com.clinicaodonto.controller;

import com.clinicaodonto.model.AddressModel;
import com.clinicaodonto.model.AppointmentModel;
import com.clinicaodonto.service.AddressService;
import com.clinicaodonto.service.AppointementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointementService service;

    @PostMapping
    public ResponseEntity<AppointmentModel> save(@RequestBody AppointmentModel appointmentModel){
        return ResponseEntity.ok(service.save(appointmentModel));
    }

    @GetMapping
    public ResponseEntity<List<AppointmentModel>> selectAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
