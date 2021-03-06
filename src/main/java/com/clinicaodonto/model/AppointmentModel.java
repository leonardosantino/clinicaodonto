package com.clinicaodonto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "appointment") @Getter @Setter
public class AppointmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAppointment;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false) @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate appointmentDate;

    // FK Dentist
    @Column
    private Integer fkDentist;

    // FK Patient
    @Column
    private Integer fkPatient;

    // Dentist
    @ManyToOne
    @JoinColumn(name = "fkDentist", insertable = false, updatable = false) @JsonIgnoreProperties({"patients", "appointments"})
    private DentistModel dentist;

    // Patient
    @ManyToOne
    @JoinColumn(name = "fkPatient", insertable = false, updatable = false) @JsonIgnoreProperties({"dentist","addresses", "appointments"})
    private PatientModel patient;
}