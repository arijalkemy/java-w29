package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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
    private StudentDAO studentDAO;
    
    @MockBean
    private StudentRepository studentRepository;

    SubjectDTO math = new SubjectDTO("Matemáticas", 10.0);
    SubjectDTO biology = new SubjectDTO("Biology", 8.0);

    StudentDTO student = StudentDTO.builder()
            .id(1L)
            .studentName("Agos")
            .subjects(List.of(math, biology))
            .build();
    
    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Get existing student by id")
    void testGetStudentById() throws Exception {
        given(studentDAO.findById(1L)).willReturn(student);

        mockMvc.perform(get("/student/getStudent/{id}", student.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.studentName").value(student.getStudentName()));
    }

    // Tuve que agregar un exception handler para StudentNotFoundException porque no estaba
    @Test
    @DisplayName("Get non existing student by id")
    void testGetStudentByIdNotFound() throws Exception {
        given(studentDAO.findById(student.getId())).willThrow(StudentNotFoundException.class);

        mockMvc.perform(get("/student/getStudent/{id}", student.getId()))
                .andExpect(status().isNotFound());
    }

    // Cambié el status a created en vez de ok
    @Test
    @DisplayName("Register student successfully")
    void testRegisterStudentSuccessfully() throws Exception {
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
    @DisplayName("Register student with invalid name")
    void testRegisterInvalidName() throws Exception {
        StudentDTO invalidStudent = StudentDTO.builder()
                .studentName("agos")
                .subjects(List.of(math, biology))
                .build();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Register student with invalid subjects")
    void testRegisterInvalidSubjects() throws Exception {
        StudentDTO invalidStudent = StudentDTO.builder().studentName("Agos").subjects(List.of()).build();

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent)))
                .andExpect(status().isBadRequest());
    }

    // Cambié el endpoint del modify de post a put y de ok a no content
    @Test
    @DisplayName("Modify student successfully")
    void testModifyStudentSuccessfully() throws Exception {
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
    @DisplayName("Modify student with invalid name")
    void testModifyInvalidName() throws Exception {
        StudentDTO invalidStudent = StudentDTO.builder()
                .studentName("agos")
                .subjects(List.of(math, biology))
                .build();

        mockMvc.perform(put("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Modify student with invalid subjects")
    void testModifyInvalidSubjects() throws Exception {
        StudentDTO invalidStudent = StudentDTO.builder().studentName("Agos").subjects(List.of()).build();

        mockMvc.perform(put("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudent)))
                .andExpect(status().isBadRequest());
    }

    // Cambié el status a no content
    @Test
    @DisplayName("Remove existing student")
    void testRemoveStudentSuccessfully() throws Exception {
        mockMvc.perform(delete("/student/removeStudent/{id}", 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Remove non existing student")
    void testRemoveStudentNotFound() throws Exception {
        Long studentId = 1L;

        doThrow(StudentNotFoundException.class).when(studentDAO).delete(studentId);

        mockMvc.perform(delete("/student/removeStudent/{id}", studentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("List students")
    void testListStudents() throws Exception {
        given(studentRepository.findAll()).willReturn(Set.of(student));
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(student.getId()))
                .andExpect(jsonPath("$[0].studentName").value(student.getStudentName()))
                .andExpect(jsonPath("$[0].averageScore").value(student.getAverageScore()));
    }
}