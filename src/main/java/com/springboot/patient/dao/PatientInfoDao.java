package com.springboot.patient.dao;

import com.springboot.patient.model.Img;
import com.springboot.patient.model.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface PatientInfoDao {

//    List<Patient> selectPatient(Patient patientInfoDto);
    Patient insertPatient(Patient patient);

    Img insertImg(Img img);

    Img uploadImg(MultipartFile file);
}
