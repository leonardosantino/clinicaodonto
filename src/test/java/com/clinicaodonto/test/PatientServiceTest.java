package com.clinicaodonto.test;

import com.clinicaodonto.model.PatientModel;
import com.clinicaodonto.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    PatientService service;

    @Test
    void save() throws Exception {

        PatientModel patientModel = new PatientModel();

        patientModel.setFirstName("leonardo");
        patientModel.setLastName("santino");
        patientModel.setRg("123456789");
        patientModel.setRegistrationDate(LocalDate.parse("2021-08-05"));

        PatientModel result = service.save(patientModel);

        assertArrayEquals(patientModel, result);
    }

    private void assertArrayEquals(PatientModel result, PatientModel patientModel) {
    }
}