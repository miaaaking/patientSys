package com.springboot.patient.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.springboot.patient.controller.PatientInfoController;
import com.springboot.patient.model.Patient;
import com.springboot.patient.service.PatientInfoService;

@RunWith(MockitoJUnitRunner.class)
public class PatientInfoControllerTest {
    @Mock
    private PatientInfoService patientInfoService;
    @InjectMocks
    private PatientInfoController patientInfoController;

    private Patient patient1;
    private Patient patient2;
    private List<Patient> patients;

    @Before
    public void setUp() {
        patient1 = new Patient("왕수진", "29", "Male", "Yes", "img_url1");
        patient2 = new Patient("왕수현", "28", "Female", "No", "img_url2");
        patients = Arrays.asList(patient1, patient2);
    }

    @Test
    public void testSelectPatient() {
        when(patientInfoService.selectPatient("왕수진")).thenReturn(patients);

        List<Patient> result = patientInfoController.selectPatient("왕수진");

        assertEquals(patients, result);
    }
}
