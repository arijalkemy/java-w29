package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIT {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    IObtenerDiplomaService service;

    @MockBean
    private StudentDAO studentDAO;

    @Test
    void testOne() throws Exception{
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        analyzeScoresTI(stu.getId(),stu);
    }

    @Test
    void testTwo() throws Exception{
        StudentDTO stu = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("María");
        analyzeScoresTI(stu.getId(),stu);
    }


    private void analyzeScoresTI(Long id , StudentDTO student) throws Exception{
        when(service.analyzeScores(id)).thenReturn(student);

        this.mockmvc.perform(get("/analyzeScores/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()));
    }

}
