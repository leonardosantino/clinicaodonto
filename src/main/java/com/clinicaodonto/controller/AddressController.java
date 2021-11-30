//package com.clinicaodonto.controller;
//
//import com.clinicaodonto.model.AddressModel;
//import com.clinicaodonto.service.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController @RequestMapping("/address")
//public class AddressController {
//
//    @Autowired
//    private AddressService service;
//
//    @PostMapping
//    public ResponseEntity<AddressModel> save(@RequestBody AddressModel addressModel){
//        return ResponseEntity.ok(service.save(addressModel));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<AddressModel>> selectAll(){
//        return ResponseEntity.ok(service.findAll());
//    }
//}
