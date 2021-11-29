package com.clinicaodonto.service;

import com.clinicaodonto.model.PatientModel;
import com.clinicaodonto.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public PatientModel save(PatientModel patientModel){
        return repository.save(patientModel);
    }

    public PatientModel editById(Integer id, PatientModel patientModel){

        PatientModel patientEdited = repository.getById(id);

        if (patientModel.getFirstName() != null)
            patientEdited.setFirstName(patientModel.getFirstName());
        if (patientModel.getLastName() != null)
            patientEdited.setLastName(patientModel.getLastName());
        if (patientModel.getRg() != null)
            patientEdited.setRg(patientModel.getRg());
        if (patientModel.getRegistrationDate() != null)
            patientEdited.setRegistrationDate(patientModel.getRegistrationDate());
        if (patientModel.getFkDentist() != null)
            patientEdited.setFkDentist(patientModel.getFkDentist());

        return repository.save(patientEdited);
    }

    public String deleteById(Integer id){
        repository.deleteById(id);
        return id + " Patient deleted !";
    }

    public Optional<PatientModel> getById(Integer id){
        return repository.findById(id);
    }

    public List<PatientModel> findAll(){
        return repository.findAll();
    }
}