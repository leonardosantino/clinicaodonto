package com.clinicaodonto.service;

import com.clinicaodonto.model.DentistModel;
import com.clinicaodonto.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistService {

    @Autowired
    private DentistRepository repository;

    public DentistModel save(DentistModel dentistModel){
        return repository.save(dentistModel);
    }

    public List<DentistModel> findAll(){
        return repository.findAll();
    }
}
