package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Student score < 9")
    public void testAnalyzeScore_whenStudentScoreIsLowerThanNine_thenReturnOk() throws Exception {
        SubjectDTO subject1 = new SubjectDTO("matematica", 5.4);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Eliana");
        studentDTO.setMessage("El alumno Eliana ha obtenido un promedio de 5,4. Puedes mejorar.");
        studentDTO.setAverageScore(5.4);
        studentDTO.setSubjects(List.of(subject1));

        StudentDAO dao = new StudentDAO();
        dao.save(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}",1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Eliana"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(5.4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Eliana ha obtenido un promedio de 5,4. Puedes mejorar."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name").value("matematica"))
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains("matematica"));
        assertTrue(responseContent.contains("Eliana"));
        assertTrue(responseContent.contains("5.4"));
    }

    @Test
    @DisplayName("Student score > 9")
    public void testAnalyzeScore_whenStudentScoreIsGreaterThanNine_thenReturnOk() throws Exception {
        SubjectDTO subject1 = new SubjectDTO("matematica", 10D);
        SubjectDTO subject2 = new SubjectDTO("matematica II", 9D);
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setMessage("El alumno Pedro ha obtenido un promedio de 9,5. Felicitaciones!");
        studentDTO.setAverageScore(9.5);
        studentDTO.setSubjects(List.of(subject1, subject2));

        StudentDAO dao = new StudentDAO();
        dao.save(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}",2L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9.5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Pedro ha obtenido un promedio de 9,5. Felicitaciones!"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[0].name").value("matematica"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects[1].name").value("matematica II"))
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains("matematica"));
        assertTrue(responseContent.contains("Pedro"));
        assertTrue(responseContent.contains("9.5"));
    }

    @Test
    @DisplayName("when user doesn't exist")
    void testAnalyzeScore_whenStudentDoesntExist_thenReturn404() throws Exception {
        // arrange
        Long userId = 5L;

        // Act & Assert
        mockMvc.perform(get("/analyzeScores/{studentId}", userId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("when user is invalid")
    void testAnalyzeScore_whenStudentIsInvalid_thenReturn400() throws Exception {
        // arrange
        String userId = "usuario";

        // Act & Assert
        mockMvc.perform(get("/analyzeScores/{studentId}", userId))
                .andExpect(status().isBadRequest());
    }
}