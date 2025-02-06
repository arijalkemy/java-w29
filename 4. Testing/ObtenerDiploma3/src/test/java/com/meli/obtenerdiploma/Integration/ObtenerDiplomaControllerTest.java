package com.meli.obtenerdiploma.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {
    @Autowired
    MockMvc mockMvc;
    StudentDTO studentDTO;

    @BeforeEach
    void setUpt(){
        studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");

    }

    @Test
    void analyzeScoresTest() throws Exception {
        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        String studentJson = ow.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());

       mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}