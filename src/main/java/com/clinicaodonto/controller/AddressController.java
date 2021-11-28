package com.clinicaodonto.controller;

import com.clinicaodonto.model.AddressModel;
import com.clinicaodonto.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping("/save")
    public ResponseEntity<AddressModel> save(@RequestBody AddressModel addressModel){
        return ResponseEntity.ok(service.save(addressModel));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AddressModel>> selectAll(){
        return ResponseEntity.ok(service.findAll());
    }
}
