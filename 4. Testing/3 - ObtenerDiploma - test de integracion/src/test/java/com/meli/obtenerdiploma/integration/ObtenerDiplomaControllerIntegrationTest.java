package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("analyzeScores - OK - score < 9")
    void analyzeScoresTest_whenStudentExists1_thenReturnDTO() throws Exception {
        // arrange
        StudentDTO expected = new StudentDTO(
                1L,
                "Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of());

        // act & assert
        mockMvc.perform(get("/analyzeScores/{studentId}", expected.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value(expected.getStudentName()))
                .andExpect(jsonPath("$.averageScore").value(expected.getAverageScore()))
                .andExpect(jsonPath("$.message").value(expected.getMessage()));
    }

    @Test
    @DisplayName("analyzeScores - OK - score > 9")
    void analyzeScoresTest_whenStudentExists2_thenReturnDTO() throws Exception {
        // arrange
        StudentDTO expected = new StudentDTO(
                2L,
                "Pedro",
                "El alumno Pedro ha obtenido un promedio de 9,00. Felicitaciones!",
                9D,
                List.of());

        // act & assert
        mockMvc.perform(get("/analyzeScores/{studentId}", expected.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value(expected.getStudentName()))
                .andExpect(jsonPath("$.averageScore").value(expected.getAverageScore()))
                .andExpect(jsonPath("$.message").value(expected.getMessage()));
    }

    @Test
    @DisplayName("analyzeScores - 404")
    void analyzeScoresTest_whenStudentDoesntExist_thenReturn404() throws Exception {
        // arrange
        Long studentId = 4L;
        // act & assert
        mockMvc.perform(get("/analyzeScores/{studentId}", studentId))
                .andExpect(status().isNotFound());
    }
}
