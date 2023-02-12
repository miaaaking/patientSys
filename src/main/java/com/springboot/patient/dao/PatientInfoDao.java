package com.springboot.patient.dao;

import com.springboot.patient.model.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientInfoDao {

    int insertPatient(Patient patient);

    int updateImg(Patient patient, String s);

    List<Patient> selectPatient(String patient_name);

    String selectUrl(int patient_seq);

    int delPatient(int patient_seq);
}

