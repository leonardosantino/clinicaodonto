package com.clinicaodonto.service;

import com.clinicaodonto.model.AppointmentModel;
import com.clinicaodonto.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointementService {

    @Autowired
    private AppointmentRepository repository;

    public AppointmentModel save(AppointmentModel appointmentModel){
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

        return repository.save(appointmentEdited);
    }

    public Optional<AppointmentModel> getById(Integer id){
        return repository.findById(id);
    }

    public List<AppointmentModel> findAll(){
        return repository.findAll();
    }

}
