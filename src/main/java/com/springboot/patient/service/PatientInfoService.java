package com.springboot.patient.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import com.springboot.patient.dao.PatientInfoDao;
import com.springboot.patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PatientInfoService {
    @Autowired
    PatientInfoDao dao;
    private Object patient_seq;

    public int insertPatient(Patient patient) {
        return dao.insertPatient(patient);
    }

    public Path uploadImg(MultipartFile file, int patientSeq) throws IOException {
        Path filePath = null;

        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            String fileName = file.getOriginalFilename();
            String conType = file.getContentType();
            if (conType.equals("image/jpeg") || conType.equals("image/png")) {
                Path path = Paths.get("src/main/resources/static/images/" + fileName);
                Files.write(path, bytes);
                filePath = path;
            }
        }
        return filePath;
    }

    public int updateImg(Patient patient, String filePath) {
        patient.setImg_url(filePath);
        return dao.updateImg(patient, "path/to/image.png");
    }

    @Transactional
    public ResponseEntity<Resource> insert(Patient patient, MultipartFile file) {
        int insertedPatient = dao.insertPatient(patient);

        HttpHeaders header = new HttpHeaders();
        Resource resource = null;
        try {
            Path filePath = uploadImg(file, patient.getPatient_seq());
            header.add("Content-Type", Files.probeContentType(filePath));
            resource = new FileSystemResource(filePath.toString());

            String str = resource.toString();
            String result = str.replace("]", "");
            String result2 = result.replace("file [", "");
            updateImg(patient, result2);
            System.out.println(result2);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);

    }
    
    public List<Patient> selectPatient(String patient_name) {
        return dao.selectPatient(patient_name);
    }

    public String selectUrl(int patient_seq) {
        return dao.selectUrl(patient_seq);
    }

    public int delPatient(int patient_seq) {
        return dao.delPatient(patient_seq);
    }
}
