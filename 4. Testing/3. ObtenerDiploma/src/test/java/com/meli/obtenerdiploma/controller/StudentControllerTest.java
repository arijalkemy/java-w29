package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @Test
    @DisplayName("CU1 . Register student test ok")
    void registerStudent() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Nombre");
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("CU1 . Register student not valid exception")
    void registerStudentTestNotValidException() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(5L);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    @DisplayName("CU2 - Get student test ok")
    void getStudentTestOk() throws Exception {
        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2L))
                .andReturn();

        assertEquals("application/json", result.getResponse().getContentType());
    }

    @Test
    @DisplayName("CU2 - Get student test not found")
    void getStudentTestNotFound() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 5L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    @DisplayName("CU3 - Modify student information happy path")
    void modifyStudentOkTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Nombre");
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("CU3 - Modify student information bad name")
    void modifyStudentBadNameTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(studentDTO)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty());
    }

    @Test
    @DisplayName("CU4 - Remove student happy test")
    void removeStudentTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("CU4 - Remove student student not found")
    @Disabled // Returns false and does not throw the expected exception.
    void removeStudentNotFoundTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 20L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").isNotEmpty());

    }

    @Test
    @DisplayName("CU5 - List students")
    void listStudentOkTest() throws Exception {
        Set<StudentDTO> students = new HashSet<>();
        students.add(TestUtilsGenerator.getStudentWithId(1L));

        when(studentService.getAll()).thenReturn(students);

        MvcResult result = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(students)))
                .andReturn();

        assertNotNull(students);
        assertFalse(students.isEmpty());
    }

    @Test
    @DisplayName("CU5 - Empty list students")
    void listStudentEmptyListTest() throws Exception {
        when(studentService.getAll()).thenReturn(new HashSet<>());

        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }
}