package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ObtenerDiplomaService diplomaService;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan Perez");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Historia", 8.0),
                new SubjectDTO("Ciencias", 10.0)
        ));
    }

    //hacer test de integracion para el controller de obtener diploma controller
    @Test
    void testGetDiploma() throws Exception {
        when(diplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/1"))
        .andDo(print()) 
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Juan Perez")));
    }

}
