package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {

    @Autowired
    private MockMvc mockMvc;

    StudentDAO studentDAO = new StudentDAO();

    SubjectDTO sbj1;
    SubjectDTO sbj2;
    SubjectDTO sbj3;
    StudentDTO student;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void beforEach() {
        sbj1 = new SubjectDTO("Kahoot", 1.0);
        sbj2 = new SubjectDTO("Musica", 9.0);
        sbj3 = new SubjectDTO("POO", 2.0);
        student = new StudentDTO(15L, "Juan", "Test", 8.0, List.of(sbj1, sbj2, sbj3));
        StudentDAO.students.add(student);
    }

    @Test
    public void analyzeScores() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 15L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                .andExpect(jsonPath("$.id").value(15L))
                .andExpect(jsonPath("$.subjects[?(@.name == \"" + sbj1.getName() + "\"  && @.score == " + sbj1.getScore() + ")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \"" + sbj2.getName() + "\"  && @.score == " + sbj2.getScore() + ")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == \"" + sbj3.getName() + "\"  && @.score == " + sbj3.getScore() + ")]").exists());
    }

    @Test
    public void analyzeScoresWithAnInvalidStudentIdThrowExceptionMessage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 88L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}
