package com.clinicaodonto.service;

import com.clinicaodonto.model.AppointmentModel;
import com.clinicaodonto.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointementService {

    @Autowired
    private AppointmentRepository repository;

    public AppointmentModel save(AppointmentModel appointmentModel){
        return repository.save(appointmentModel);
    }

    public List<AppointmentModel> findAll(){
        return repository.findAll();
    }

}
