package com.clinicaodonto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address") @Getter @Setter
public class AddressModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAddress;

    @Column(length = 20, nullable = false)
    private String street;

    @Column(length = 10, nullable = false)
    private String number;

    @Column(length = 20, nullable = false)
    private String district;

    @Column(length = 20, nullable = false)
    private String city;

    @Column(length = 20, nullable = false)
    private String state;

    // FK Pacient
    @Column
    private Integer fkPatient;

    // Pacient
    @ManyToOne
    @JoinColumn(name = "fkPatient" , insertable = false, updatable = false) @JsonIgnoreProperties({"dentist", "addresses"})
    private PatientModel patient;
}