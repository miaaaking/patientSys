//package com.springboot.patient.service;
//
//import static org.junit.Assert.*;
//
//import com.springboot.patient.dao.PatientInfoDao;
//import com.springboot.patient.model.Patient;
//import com.springboot.patient.service.PatientInfoService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.core.io.Resource;
//
//@RunWith(SpringRunner.class)
//public class PatientInfoServiceTest {
//
//    @TestConfiguration
//    static class PatientInfoServiceTestContextConfiguration {
//        @Bean
//        public PatientInfoService patientInfoService() {
//            return new PatientInfoService();
//        }
//    }
//
//    @Autowired
//    private PatientInfoService patientInfoService;
//
//    @MockBean
//    private PatientInfoDao patientInfoDao;
//
//    @Before
//    public void setUp() {
//        Patient patient = new Patient();
//        patient.setPatient_seq(1111);
//        patient.setPatient_name("왕수진");
//
//        Mockito.when(patientInfoDao.insertPatient(patient))
//                .thenReturn(1);
//
//        Mockito.when(patientInfoDao.updateImg(patient, "path/to/image.png"))
//                .thenReturn(1);
//    }
//
//    @Test
//    public void testInsert() throws Exception {
//        Patient patient = new Patient();
//        patient.setPatient_seq(1111);
//        patient.setPatient_name("왕수진");
//
//        MockMultipartFile file = new MockMultipartFile("image.png", "image.png", "image/png", "Tempimage".getBytes());
//
//        ResponseEntity<Resource> response = patientInfoService.insert(patient, file);
//
//        assertNotNull(response);
//        assertEquals(200, response.getStatusCodeValue());
//    }
//
//}
