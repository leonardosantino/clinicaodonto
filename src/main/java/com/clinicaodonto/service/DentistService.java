package com.clinicaodonto.service;

import com.clinicaodonto.model.DentistModel;
import com.clinicaodonto.repository.DentistRepository;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {
    private static final Logger logger = Logger.getLogger(DentistService.class);

    @Autowired
    private DentistRepository repository;

    public DentistModel save(DentistModel dentistModel){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Insert Dentist" + " Name: " + dentistModel.getFirstName() + " Last name: " + dentistModel.getLastName());
        return repository.save(dentistModel);
    }

    public DentistModel editById(Integer id, DentistModel dentistModel){

        DentistModel dentistEdited = repository.getById(id);
        if (dentistModel.getFirstName() != null)
            dentistEdited.setFirstName(dentistModel.getFirstName());
        if (dentistModel.getLastName() != null)
            dentistEdited.setLastName(dentistModel.getLastName());
        if (dentistModel.getRegistration() != null)
            dentistEdited.setRegistration(dentistModel.getRegistration());

        PropertyConfigurator.configure("log4j.properties");
        logger.info("Edit Dentist" + " Name: " + dentistEdited.getFirstName() + " Last name: " + dentistEdited.getLastName());
        return repository.save(dentistEdited);
    }

    public Optional<DentistModel> getById(Integer id){
        return repository.findById(id);
    }

    public String deleteById(Integer id){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Delete Dentist" + " ID: " + id);

        repository.deleteById(id);
        return id + " Dentist deleted !";
    }

    public List<DentistModel> findAll(){
        return repository.findAll();
    }
}
