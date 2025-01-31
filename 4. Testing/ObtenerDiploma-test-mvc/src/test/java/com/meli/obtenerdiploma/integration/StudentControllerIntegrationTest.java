package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IStudentDAO studentDAO;

    private StudentDTO testInvalidStudent;
    private StudentDTO testStudent;
    private StudentDTO testStudent2;

    @BeforeEach
    void setup() {
        // Crear datos de prueba
        testStudent = new StudentDTO();
        testStudent.setId(1L);
        testStudent.setStudentName("Juan Perez");

        testStudent2 = new StudentDTO();
        testStudent2.setId(2L);
        testStudent2.setStudentName("Mateo Perez");

        testInvalidStudent = new StudentDTO();
        testInvalidStudent.setId(3L);
        testInvalidStudent.setStudentName("nombre inválido");

        // Crear algunas materias con notas
        SubjectDTO subject1 = new SubjectDTO("Matematicas", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Fisica", 8.0);
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
    void registerStudent_validStudent() throws Exception {
        String jsonContent = new ObjectMapper().writeValueAsString(testStudent);

        MvcResult result = mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(), "");
    }

    @Test
    void registerStudent_invalidStudent() throws Exception {
        String jsonContent = new ObjectMapper().writeValueAsString(testInvalidStudent);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void getStudent_id_ok() throws Exception {
        MvcResult result = mockMvc.perform(get("/student/getStudent/{studentId}", testStudent.getId())
                            .contentType(MediaType.APPLICATION_JSON))
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
    }

    @Test
    void modifyStudent_validStudent() throws Exception {
        String jsonContent = new ObjectMapper().writeValueAsString(testStudent);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void modifyStudent_invalidStudent() throws Exception {
        String jsonContent = new ObjectMapper().writeValueAsString(testInvalidStudent);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void removeStudent_validId() throws Exception {
        MvcResult result = mockMvc.perform(get("/student/removeStudent/{studentId}", testStudent.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        // Obtener la respuesta y convertirla a StudentDTO
        String responseContent = result.getResponse().getContentAsString();

        // 3. Assert
        assertEquals("", responseContent);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(testStudent.getId()));
    }

    @Test
    void listStudents() throws Exception {
        // 2. Act
        MvcResult result = mockMvc.perform(get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<StudentDTO> responseStudents = objectMapper.readValue(
                responseContent,
                new TypeReference<List<StudentDTO>>() {}
        );

        // 3. Assert
        assertNotNull(responseStudents);
        assertFalse(responseStudents.isEmpty());
    }



}
