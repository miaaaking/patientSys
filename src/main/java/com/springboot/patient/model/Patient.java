package com.springboot.patient.model;

import lombok.Builder;
import lombok.Data;

import java.util.Random;

@Data
public class Patient {

    private String patient_code;
    private String patient_name;
    private String patient_age;
    private String patient_sex;
    private String disease_yn;

    public String getRandomCode(int length) {
        String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int alphaNumLength = alphaNum.length();

        Random random = new Random();

        StringBuffer code = new StringBuffer();
        for (int i = 0; i < length; i++) {
            code.append(alphaNum.charAt(random.nextInt(alphaNumLength)));
        }

        return code.toString();
    }

    @Builder
    public Patient(String patient_code, String patient_name, String patient_age, String patient_sex, String disease_yn){
        this.patient_code = "ptnt_"+getRandomCode(20);
        this.patient_name = patient_name;
        this.patient_age = patient_age;
        this.patient_sex = patient_sex;
        this.disease_yn = disease_yn;
    }
}
