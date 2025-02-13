package com.meli.obtenerdiploma.controllerTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldAnalyzeScores() throws Exception {
        // Prepare test data
        StudentDTO expectedStudent = new StudentDTO(
                10L,
                "Bart Simpson",
                "El alumno Bart Simpson ha obtenido un promedio de 9,5. Felicitaciones!",
                9.5,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("English", 9.0))
        );

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Bart Simpson ha obtenido un promedio de 9,5. Felicitaciones!"));
    }
}
