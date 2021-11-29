package com.clinicaodonto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dentist") @Setter @Getter
public class DentistModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDentist;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false)
    private String registration;

    // Pacients list
    @OneToMany(mappedBy = "dentist") @JsonIgnoreProperties({"dentist", "addresses","appointments"})
    private List<PatientModel> patients;

    // Appointment list
    @OneToMany(mappedBy = "dentist") @JsonIgnoreProperties({"dentist", "patient"})
    private List<AppointmentModel> appointments;
}
