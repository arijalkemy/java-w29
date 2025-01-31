package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IStudentDAO studentDAO;

    private StudentDTO testStudent;
    private StudentDTO testStudent2;

    @BeforeEach
    void setUp() {
        // Crear datos de prueba
        testStudent = new StudentDTO();
        testStudent.setId(1L);
        testStudent.setStudentName("Juan Perez");

        testStudent2 = new StudentDTO();
        testStudent2.setId(2L);
        testStudent2.setStudentName("Mateo Perez");

        // Crear algunas materias con notas
        SubjectDTO subject1 = new SubjectDTO("Matematicas", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 9.0);
        SubjectDTO subject3 = new SubjectDTO("Quimica", 10.0);

        SubjectDTO subject4 = new SubjectDTO("Matematicas", 6.0);
        SubjectDTO subject5 = new SubjectDTO("Fisica", 1.0);
        SubjectDTO subject6 = new SubjectDTO("Quimica", 1.0);

        testStudent.setSubjects(Arrays.asList(subject1, subject2, subject3));
        testStudent2.setSubjects(Arrays.asList(subject4, subject5, subject6));

        // Guardar el estudiante en el DAO
        studentDAO.save(testStudent);
        studentDAO.save(testStudent2);
    }

    @Test
    void analyzeScores_ValidStudent_ReturnsCorrectDiploma() throws Exception {
        // Ejecutar la petición GET
        MvcResult result = mockMvc.perform(get("/analyzeScores/{studentId}", testStudent.getId()).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // Obtener la respuesta y convertirla a StudentDTO
        String responseContent = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        StudentDTO responseStudent = objectMapper.readValue(responseContent, StudentDTO.class);

        // Verificaciones
        assertNotNull(responseStudent);
        assertEquals(testStudent.getId(), responseStudent.getId());
        assertEquals(testStudent.getStudentName(), responseStudent.getStudentName());
        assertEquals(9.33, responseStudent.getAverageScore(), 0.01); // Promedio esperado
        assertTrue(responseStudent.getMessage().contains("Felicitaciones")); // Debe contener felicitaciones por promedio >= 9
    }

    @Test
    void analyzeScores_ValidStudent_ReturnsCorrectDiploma_NoAprove() throws Exception {
        // Ejecutar la petición GET
        MvcResult result = mockMvc.perform(get("/analyzeScores/{studentId}", testStudent2.getId()).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // Obtener la respuesta y convertirla a StudentDTO
        String responseContent = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        StudentDTO responseStudent = objectMapper.readValue(responseContent, StudentDTO.class);

        // Verificaciones
        assertNotNull(responseStudent);
        assertEquals(testStudent2.getId(), responseStudent.getId());
        assertEquals(testStudent2.getStudentName(), responseStudent.getStudentName());
        assertEquals(2.66, responseStudent.getAverageScore(), 0.01); // Promedio esperado
    }

    @Test
    void analyzeScores_NonExistentStudent_ReturnsNotFound() throws Exception {
        Long nonExistentId = 999L;

        mockMvc.perform(get("/analyzeScores/{studentId}", nonExistentId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
