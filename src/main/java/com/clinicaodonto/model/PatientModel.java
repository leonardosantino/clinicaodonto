package com.clinicaodonto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity @Setter @Getter
@Table(name = "patient")
public class PatientModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPatient;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false)
    private String rg;

    @Column(nullable = false)
    private Date registrationDate;

    // FK Dentist
    @Column(nullable = false)
    private Integer fkDentist;

    // Addresses list
    @OneToMany(mappedBy = "patient") @JsonIgnoreProperties({"patient"})
    private List<AddressModel>  addresses;

    // Dentist
    @ManyToOne
    @JoinColumn(name = "fkDentist", insertable = false, updatable = false) @JsonIgnoreProperties({"pacients"})
    private DentistModel dentist;

}
