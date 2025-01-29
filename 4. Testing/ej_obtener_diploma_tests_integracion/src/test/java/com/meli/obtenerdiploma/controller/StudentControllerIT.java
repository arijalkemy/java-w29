package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    SubjectDTO math = new SubjectDTO("Matemáticas", 10.0);
    SubjectDTO biology = new SubjectDTO("Biology", 8.0);


    StudentDTO student = StudentDTO.builder()
            .id(1L)
            .studentName("Agos")
            .subjects(List.of(math, biology))
            .averageScore(9.0)
            .build();

    @Test
    @DisplayName("Get existing student by id")
    void testGetStudentById() throws Exception {
        given(studentService.read(student.getId())).willReturn(student);

        mockMvc.perform(get("/student/getStudent/{id}", student.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.studentName").value(student.getStudentName()))
                .andExpect(jsonPath("$.averageScore").value(student.getAverageScore()));
    }

    // Tuve que agregar un exception handler para StudentNotFoundException porque no estaba
    @Test
    @DisplayName("Get non existing student by id")
    void testGetStudentByIdNotFound() throws Exception {
        Long studentId = 1L;

        given(studentService.read(studentId)).willThrow(StudentNotFoundException.class);

        mockMvc.perform(get("/student/getStudent/{id}", studentId))
                .andExpect(status().isNotFound());
    }

    // Cambié el status a created en vez de ok
    @Test
    @DisplayName("Register student successfully")
    void testRegisterStudentSuccessfully() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Register student with no body")
    void testRegisterNoStudent() throws Exception {
        mockMvc.perform(post("/student/registerStudent"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Register student with invalid body")
    void testRegisterInvalidStudent() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        StudentDTO invalidStudent1 = StudentDTO.builder()
                .studentName("agos")
                .subjects(List.of(math, biology))
                .build();
        StudentDTO invalidStudent2 = StudentDTO.builder().studentName("Agos").subjects(List.of()).build();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent1)))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent2)))
                .andExpect(status().isBadRequest());
    }

    // Cambié el endpoint del modify de post a put y de ok a no content
    @Test
    @DisplayName("Modify student successfully")
    void testModifyStudentSuccessfully() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(put("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Modify student with no body")
    void testModifyNoStudent() throws Exception {
        mockMvc.perform(put("/student/modifyStudent"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Modify student with invalid body")
    void testModifyInvalidStudent() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        StudentDTO invalidStudent1 = StudentDTO.builder()
                .studentName("agos")
                .subjects(List.of(math, biology))
                .build();
        StudentDTO invalidStudent2 = StudentDTO.builder().studentName("Agos").subjects(List.of()).build();

        mockMvc.perform(put("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent1)))
                .andExpect(status().isBadRequest());

        mockMvc.perform(put("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent2)))
                .andExpect(status().isBadRequest());
    }

    // Cambié el status a no content
    @Test
    @DisplayName("Remove existing student")
    void testRemoveStudentSuccessfully() throws Exception {
        mockMvc.perform(delete("/student/removeStudent/{id}", student.getId()))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Remove non existing student")
    void testRemoveStudentNotFound() throws Exception {
        Long studentId = 1L;

        doThrow(StudentNotFoundException.class).when(studentService).delete(studentId);

        mockMvc.perform(delete("/student/removeStudent/{id}", studentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("List students")
    void testListStudents() throws Exception {
        given(studentService.getAll()).willReturn(Set.of(student));
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(student.getId()))
                .andExpect(jsonPath("$[0].studentName").value(student.getStudentName()))
                .andExpect(jsonPath("$[0].averageScore").value(student.getAverageScore()));
    }
}