package com.clinicaodonto.service;

import com.clinicaodonto.model.PatientModel;
import com.clinicaodonto.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public PatientModel save(PatientModel patientModel){
        return repository.save(patientModel);
    }

    public List<PatientModel> findAll(){
        return repository.findAll();
    }

}
