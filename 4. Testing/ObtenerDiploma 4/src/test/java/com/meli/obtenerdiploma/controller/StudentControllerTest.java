package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    StudentDTO studentDTO;
    @BeforeEach
    void set(){
        studentDTO= TestUtilsGenerator.getStudentWith3Subjects("Pepe");
    }

    @Test
    void registerStudent() throws Exception {
        ObjectWriter objectWriter=new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        String studentJson= objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print()) .andExpect(status().isOk());
    }

    @Test
    void getStudent() throws Exception {

        Long id=studentDTO.getId();
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Pepe"));
    }
    @Test
    void getStudentNotFound() throws Exception {

        Long id=studentDTO.getId();
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",12738912937912L))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    void modifyStudent()throws  Exception {
        ObjectWriter objectWriter=new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Jose");
        String studentJson= objectWriter.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content( studentJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void removeStudent() {
    }

    @Test
    void listStudents() {
    }
}