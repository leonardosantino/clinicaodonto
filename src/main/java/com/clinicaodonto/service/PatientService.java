package com.clinicaodonto.service;

import com.clinicaodonto.model.PatientModel;
import com.clinicaodonto.repository.PatientRepository;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private static final Logger logger = Logger.getLogger(PatientService.class);

    @Autowired
    private PatientRepository repository;

    public PatientModel save(PatientModel patientModel){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Insert Patient" + " Name: " + patientModel.getFirstName() + " Last name: " + patientModel.getLastName());
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

        PropertyConfigurator.configure("log4j.properties");
        logger.info("Edit Patient" + " Name: " + patientModel.getFirstName() + " Last name: " + patientModel.getLastName());

        return repository.save(patientEdited);
    }

    public String deleteById(Integer id){
        repository.deleteById(id);
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Delete Patient" + " ID: " + id);
        return id + " Patient deleted !";
    }

    public Optional<PatientModel> getById(Integer id){
        return repository.findById(id);
    }

    public List<PatientModel> findAll(){
        return repository.findAll();
    }
}