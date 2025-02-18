package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    IStudentService studentService;
    @Autowired
    IStudentDAO studentDAO;

    /*@Test
    public void test_registerStudent_ok() throws Exception {
        StudentDTO studentDTO = new StudentDTO(7L,"Nico","",0.0, List.of(
                new SubjectDTO("matematica",8.0),
                new SubjectDTO("lengua",10.0)
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent",studentDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        studentDAO.delete(studentDTO.getId());
    }*/

    @Test
    public void test_getStudent_ok() throws Exception{
        StudentDTO studentDTO = new StudentDTO(7L,"Nico","",0.0, List.of(
                new SubjectDTO("matematica",8.0),
                new SubjectDTO("lengua",10.0)
        ));
        studentDAO.save(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(studentDTO.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Nico"));
        studentDAO.delete(studentDTO.getId());
    }
    @Test
    public void test_getStudent_noOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",17))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                                .value("El alumno con Id 17 no se encuetra registrado."));
    }

    @Test
    public void test_removeStudent_ok() throws Exception{
        StudentDTO studentDTO = new StudentDTO(7L,"Nico","",0.0, List.of(
                new SubjectDTO("matematica",8.0),
                new SubjectDTO("lengua",10.0)
        ));
        studentDAO.save(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", studentDTO.getId()))
                .andDo(print())
                .andExpect(status().isOk());
        assertFalse(studentDAO.exists(studentDTO));
    }

    @Test
    public void test_removeStudent_noOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 100))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
                //.andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        //.value("El alumno con Id 17 no se encuetra registrado."));
    }
}
