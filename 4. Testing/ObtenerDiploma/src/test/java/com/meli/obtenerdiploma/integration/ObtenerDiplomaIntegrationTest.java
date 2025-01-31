package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Obtener diploma 10")
    void obtenerDiplomaTest() throws Exception {
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",10.0));
        StudentDTO student = new StudentDTO(1L,
                "Pepe","El alumno Pepe ha obtenido un promedio de 10. Felicitaciones!",
                10.0,subjetc);

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(payload, result.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obtener diploma menos de 9")
    void obtenerDiplomaMejorarTest() throws Exception {
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.0));
        StudentDTO student = new StudentDTO(1L,
                "Pepe","El alumno Pepe ha obtenido un promedio de 7. Puedes mejorar.",
                7.0,subjetc);

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(student);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(payload, result.getResponse().getContentAsString());

    }
}
