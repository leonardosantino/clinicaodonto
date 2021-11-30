package com.clinicaodonto.service;

import com.clinicaodonto.model.AppointmentModel;
import com.clinicaodonto.repository.AppointmentRepository;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private static final Logger logger = Logger.getLogger(DentistService.class);

    @Autowired
    private AppointmentRepository repository;

    public AppointmentModel save(AppointmentModel appointmentModel){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Insert Appointment" + " Description: " + appointmentModel.getDescription() + " Date: " + appointmentModel.getAppointmentDate());

        return repository.save(appointmentModel);
    }

    public AppointmentModel editById(Integer id, AppointmentModel appointmentModel){

        AppointmentModel appointmentEdited = repository.getById(id);

        if (appointmentModel.getDescription() != null)
            appointmentEdited.setDescription(appointmentModel.getDescription());

        if (appointmentModel.getAppointmentDate() != null)
            appointmentEdited.setAppointmentDate(appointmentModel.getAppointmentDate());

        if (appointmentModel.getFkPatient() != null)
            appointmentEdited.setFkPatient(appointmentModel.getFkPatient());

        if (appointmentModel.getFkDentist() != null)
            appointmentEdited.setFkDentist(appointmentModel.getFkDentist());

        PropertyConfigurator.configure("log4j.properties");
        logger.info("Edit Appointment" + " Description: " + appointmentModel.getDescription() + " Date: " + appointmentModel.getAppointmentDate());

        return repository.save(appointmentEdited);
    }

    public String deleteById(Integer id){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Delete Appointment" + " ID: " + id);

        repository.deleteById(id);
        return id + " Appointment deleted !";
    }

    public Optional<AppointmentModel> getById(Integer id){
        return repository.findById(id);
    }

    public List<AppointmentModel> findAll(){
        return repository.findAll();
    }
}