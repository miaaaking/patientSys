package com.springboot.patient.controller;

import com.springboot.patient.model.Img;
import com.springboot.patient.model.Patient;
import com.springboot.patient.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientInfoController {

    @Autowired
    private PatientInfoService service;

//    @GetMapping("/{patient_seq}")
//    public List<Patient> selectPatient(Model model) {
//        return service.selectPatient();
//    }
    @PostMapping("")
    public ResponseEntity<Patient> insertPatient(@RequestBody Patient patient) {
        try {
            Patient insertedPatient = service.insertPatient(patient);
            return ResponseEntity.ok(insertedPatient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/uploadimg")
    public ResponseEntity uploadImage(@RequestParam("file") MultipartFile file, @Value("${spring.servlet.multipart.location}") File path) {


        String fileName = file.getOriginalFilename();
//        File path = new File("/imgs" + fileName);
        path = new File(path + fileName);

        try {
            // 파일 이름 특수문자 제외
            file.transferTo(path);
            System.out.println(path);

            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to upload image: " + e.getMessage());
        }
    }
}
