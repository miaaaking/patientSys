package com.springboot.patient.controller;

import com.springboot.patient.service.PatientInfoService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PatientTest {

    @LocalServerPort
    private int port;

    @Autowired
    private PatientInfoService service;

//    @After
//    public void tearDown() throws Exception {
//        PatientInfoService.deleteAll();
//    }

    @Test
    public void insertPatientTest() throws Exception {
        // given
        String patient_name = "Test";
        String patient_age = "10";
        String patient_sex = "A";
        String disease_yn = "A";

        String url = "http://localhost:"+port+"/patient/";

        // when

    }
}
