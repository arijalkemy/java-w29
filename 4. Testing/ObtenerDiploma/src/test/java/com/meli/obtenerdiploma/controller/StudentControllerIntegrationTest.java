package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.Assert;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;


    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        TestUtilsGenerator.emptyUsersFile();
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteAll();
        studentDAO.save(TestUtilsGenerator.getStudentWith3Subjects("Andres"));
    }

    @Test
    public void registerStudentOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andres");

        mockMvc.perform(post("/student/registerStudent")
                        .content(writer.writeValueAsString(studentDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentOk() throws Exception {
        StudentDTO expectedStudentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andres");
        expectedStudentDTO.setId(1L);
        new StudentDAO().save(expectedStudentDTO);

        mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(writer.writeValueAsString(expectedStudentDTO)));
    }

    @Test
    public void modifyStudentOk() throws Exception {
        StudentDTO studentDTOToModify = TestUtilsGenerator.getStudentWith3Subjects("Andres");
        studentDTOToModify.setId(2L);
        studentDTOToModify.setStudentName("Andres Largo");

        mockMvc.perform(post("/student/modifyStudent")
                        .content(writer.writeValueAsString(studentDTOToModify))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudentOk() throws Exception {
        TestUtilsGenerator.emptyUsersFile();
        Set<StudentDTO> expectedStudentDTOSet = TestUtilsGenerator.getStudentSet();
        expectedStudentDTOSet.forEach(s -> new StudentDAO().save(s));

        MvcResult res = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(writer.writeValueAsString(expectedStudentDTOSet)))
                .andReturn();

        String json = res.getResponse().getContentAsString();
        List<StudentDTO> students = new ObjectMapper().readValue(json, new TypeReference<List<StudentDTO>>() {});
        students.sort(Comparator.comparing(StudentDTO::getId));

        assertArrayEquals(expectedStudentDTOSet.toArray(), students.toArray());
    }
}
