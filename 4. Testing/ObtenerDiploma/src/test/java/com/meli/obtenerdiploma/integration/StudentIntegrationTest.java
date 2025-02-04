package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void createStudentIntegrationTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        var resultList = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        var idGet = mapper.readValue(resultList, new TypeReference<List<StudentDTO>>() {}).get(0).getId();

        var resultGet = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", idGet))
                .andReturn().getResponse().getContentAsString();

        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",10.0));
        StudentDTO student = new StudentDTO(idGet,
                "Pepe","El alumno Pepe ha obtenido un promedio de 10. Felicitaciones!",
                10.0,subjetc);

        String payload = mapper.writeValueAsString(student);


        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk());


        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk());


        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", idGet))
                .andExpect(status().isOk());

        assertEquals(payload, resultGet);
    }
}
