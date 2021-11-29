package com.clinicaodonto.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

//@Entity @Getter @Setter
//@Table(name = "appointment")
public class AppointmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAppointment;

    @Column(nullable = false)
    private DentistModel dentist;

    @Column(nullable = false)
    private PatientModel patient;

    @Column(nullable = false)
    private Date appointmentDate;

}
