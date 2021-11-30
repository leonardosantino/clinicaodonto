package com.clinicaodonto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient") @Setter @Getter
public class PatientModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false)
    private String rg;

    @Column(nullable = false) @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registrationDate;

    // FK Dentist
    @Column
    private Integer fkDentist;

    // Addresses list
    @OneToMany(mappedBy = "patient", orphanRemoval = true) @JsonIgnoreProperties({"patient"})
    private List<AddressModel>  addresses;

    // Dentist
    @ManyToOne
    @JoinColumn(name = "fkDentist", insertable = false, updatable = false) @JsonIgnoreProperties({"patients", "appointments"})
    private DentistModel dentist;

    // Appointment list
    @OneToMany(mappedBy = "patient") @JsonIgnoreProperties({"patient"})
    private List<AppointmentModel> appointments;
}