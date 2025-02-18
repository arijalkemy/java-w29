package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IObtenerDiplomaService obtenerDiplomaService;
    @Autowired
    IStudentDAO studentDAO;

    @Test
    public void test_analyzeScores_ok() throws Exception{
        StudentDTO studentDTO = new StudentDTO(7L,"Nico","",0.0, List.of(
                new SubjectDTO("matematica",8.0),
                new SubjectDTO("lengua",10.0)
        ));
        studentDAO.save(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentDTO.getId()));
        studentDAO.delete(studentDTO.getId());
    }

    @Test
    public void test_analyzeScores_NotFound() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",17))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").
                        value("El alumno con Id 17 no se encuetra registrado."));
    }

}

