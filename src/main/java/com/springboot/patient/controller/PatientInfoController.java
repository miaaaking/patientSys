package com.springboot.patient.controller;

import com.springboot.patient.model.Patient;
import com.springboot.patient.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientInfoController {
    @Autowired
    PatientInfoService service;

    @PostMapping("/save")
    public ResponseEntity<Resource> insertPatient(@RequestParam("patient_name") String patient_name,
                                                @RequestParam("patient_age") String patient_age,
                                                @RequestParam("patient_sex") String patient_sex,
                                                @RequestParam("disease_yn") String disease_yn,
                                                @RequestParam("file") MultipartFile file) {
        Patient patient = new Patient(patient_name, patient_age, patient_sex, disease_yn, null);
        return service.insert(patient, file);
    }
    @GetMapping("/getinfo")
    public List<Patient> selectPatient(@RequestParam("patient_name") String patient_name){
        return service.selectPatient(patient_name);
    }

    @GetMapping("/getimg")
    public String selectUrl(@RequestParam("patient_seq") int patient_seq){
        return "file:///" + service.selectUrl(patient_seq);
    }

    @GetMapping("/delete")
    public int delPatient(@RequestParam("patient_seq") int patient_seq){
        return service.delPatient(patient_seq);
    }
}
