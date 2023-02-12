package com.springboot.patient.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Random;

@Data
public class Img {

    private String patient_code;
    private String img_code;
    private String img_url;

    private MultipartFile img_file;

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
    public Img(String patient_code, String img_code, String img_url){
        this.patient_code = "ptnt_"+getRandomCode(20);
        this.img_code = "img_"+getRandomCode(20);
        this.img_url = img_url;
    }
}
