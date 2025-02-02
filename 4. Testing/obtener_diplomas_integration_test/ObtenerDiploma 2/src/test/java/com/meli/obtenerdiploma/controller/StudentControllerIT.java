package com.meli.obtenerdiploma.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IStudentService studentService;

    @MockBean
    private StudentDAO studentDAO;

    @Autowired
    private ObjectMapper objectMapper; // Para convertir objetos Java a JSON

    //register
    @Test
     void registerStudent () throws Exception {
         StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        String studentJson = objectMapper.writeValueAsString(stu);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isOk());
    }

    @Test
    void registerStudentInvalidname () throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("fran");
        String studentJson = objectMapper.writeValueAsString(stu);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void registerStudentIsNotBody () throws Exception {

        mockMvc.perform(post("/student/registerStudent"))
                .andExpect(status().isBadRequest());
    }

    //get id
    @Test
    void getStudent() throws Exception{
        Long id =1L;
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        when(studentService.read(id)).thenReturn(stu);

        mockMvc.perform(get("/student/getStudent/" +id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(stu.getId()))
                .andExpect(jsonPath("$.studentName").value(stu.getStudentName()));
    }

    @Test
    void getStudentNotFound() throws Exception{
        Long id =678L;

        when(studentService.read(id)).thenThrow(StudentNotFoundException.class);

        mockMvc.perform(get("/student/getStudent/" +id))
                .andExpect(status().isNotFound());
    }

    //modify student
    @Test
    void modifyStudent() throws Exception{
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        String studentJson = objectMapper.writeValueAsString(stu);

        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudentInvalidname () throws Exception {
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("fran");
        String studentJson = objectMapper.writeValueAsString(stu);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void modifyStudentIsNotBody () throws Exception {

        mockMvc.perform(post("/student/modifyStudent"))
                .andExpect(status().isBadRequest());
    }

    //remove
    @Test
    void removeStudent () throws Exception {
        Long id =1L;
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        mockMvc.perform(delete("/student/removeStudent/" +id))
                .andExpect(status().isOk());
    }

    @Test
    @Disabled
    void removeStudentNoFound () throws Exception {
        Long id =100990L;

        when(studentService.read(id)).thenThrow(StudentNotFoundException.class);

        mockMvc.perform(delete("/student/removeStudent/" +id))
                .andExpect(status().isNotFound());
    }

    //get all
    @Test
    void getStudentAll() throws Exception{
        Set<StudentDTO> stuSet = TestUtilsGenerator.getStudentSet();

        // Convertimos el Set en una Lista ordenada por ID (puede ser otro criterio)
        List<StudentDTO> stuList = new ArrayList<>(stuSet);
        stuList.sort(Comparator.comparing(StudentDTO::getId));

        when(studentService.getAll()).thenReturn(new LinkedHashSet<>(stuList)); // Mantener orden en la respuesta

        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(stuList.size())) // Verifica la cantidad de elementos en la respuesta
                .andExpect(jsonPath("$[0].id").value(stuList.get(0).getId()))
                .andExpect(jsonPath("$[0].studentName").value(stuList.get(0).getStudentName()))
                .andExpect(jsonPath("$[0].averageScore").value(stuList.get(0).getAverageScore()))
                .andExpect(jsonPath("$[1].id").value(stuList.get(1).getId()))
                .andExpect(jsonPath("$[1].studentName").value(stuList.get(1).getStudentName()));
    }

}
