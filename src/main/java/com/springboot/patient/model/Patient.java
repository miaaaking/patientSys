package com.springboot.patient.model;

import lombok.Data;

import java.util.Random;

@Data
public class Patient {
    private int patient_seq;
    private String patient_name;
    private String patient_age;
    private String patient_sex;
    private String disease_yn;

    private String img_url;

    public Patient(String patient_name, String patient_age, String patient_sex, String disease_yn, String img_url) {
        this.patient_name = patient_name;
        this.patient_age = patient_age;
        this.patient_sex = patient_sex;
        this.disease_yn = disease_yn;
        this.img_url = img_url;
    }
}
