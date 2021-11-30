package com.clinicaodonto.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getById() throws Exception{
        this.mockMvc.perform(get("/patient/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("{\"idPatient\":1,\"firstName\":\"Roberta\",\"lastName\":\"Rosas\",\"rg\":\"123456789\",\"registrationDate\":\"2021-11-30\",\"fkDentist\":null,\"addresses\":[],\"dentist\":null,\"appointments\":[]}"));
    }
}