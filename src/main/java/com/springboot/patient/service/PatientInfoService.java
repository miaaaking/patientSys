package com.springboot.patient.service;

import com.springboot.patient.dao.PatientInfoDao;
import com.springboot.patient.model.Img;
import com.springboot.patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PatientInfoService {
    @Autowired
    PatientInfoDao dao;

//    public List<Patient> selectPatient(){
//        return dao.selectPatient();
//    }
    public Patient insertPatient(Patient patient){
        return dao.insertPatient(patient);
    }

    public Img insertImg(Img img){
        return dao.insertImg(img);
    }

    public Img uploadImg(MultipartFile file){

        return dao.uploadImg(file);
    }

//    public String uploadImage(@Value("${image.upload.path}") String img_url, MultipartFile imageFile) throws IOException {
//        String fileName = imageFile.getOriginalFilename();
//        File dest = new File(img_url + fileName);
//        imageFile.transferTo(dest);
//        return fileName;
//    }
}
