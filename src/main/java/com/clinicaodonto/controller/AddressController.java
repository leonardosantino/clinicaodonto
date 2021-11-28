package com.clinicaodonto.controller;

import com.clinicaodonto.model.AddressModel;
import com.clinicaodonto.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @PostMapping("/save")
    public ResponseEntity<AddressModel> save(@RequestBody AddressModel addressModel){
        return ResponseEntity.ok(repository.save(addressModel));
    }

    @GetMapping("/selectall")
    public ResponseEntity<List<AddressModel>> selectAll(){
        return ResponseEntity.ok(repository.findAll());
    }
}
