package com.clinicaodonto.service;

import com.clinicaodonto.model.AddressModel;
import com.clinicaodonto.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public AddressModel save(AddressModel addressModel){
        return repository.save(addressModel);
    }

    public List<AddressModel> findAll(){
        return repository.findAll();
    }

}
