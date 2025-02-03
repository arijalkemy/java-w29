package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest{

    @Autowired
    MockMvc mockMvc;

    @BeforeEach @AfterEach
    void setUp(){
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("register student test ok ")
    void registerStudentOkTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        String jsonBody = new ObjectMapper().writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("register student test exception mal format ")
    void registerStudentMalFormatNameSubjectTest() throws Exception {

        String jsonBody = "{\n" +
                "    \"studentName\" : \"Null\",\n" +
                "    \"message\": \"\",\n" +
                "    \"averageScore\":\"\",\n" +
                "    \"subjects\": [\n" +
                "        {\n" +
                "            \"name\": \"matematica\",\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Ciencia\",\n" +
                "            \"score\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    @DisplayName("register student test exception mal format json body ")
    void registerStudentMalFormatJsonBodyTest() throws Exception {

        String jsonBody = "{\n" +
                "    \"studentName\" : Null,\n" +
                "    \"message\": \"\",\n" +
                "    \"averageScore\":\"\",\n" +
                "    \"subjects\": [\n" +
                "        {\n" +
                "            \"name\": \"Matematica\",\n" +
                "            \"score\": 0\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Ciencia\",\n" +
                "            \"score\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }


    @Test
    @DisplayName("get student test ok ")
    void getStudentOkTest() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        Long id = studentDTO.getId();
        TestUtilsGenerator.appendNewStudent(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(studentDTO.getId()));
    }

    @Test
    @DisplayName("get student test not exist ")
    void getStudentBadRequestTest() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        Long id = studentDTO.getId();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",id))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    @DisplayName(("update student"))
    void modifyStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        String jsonBody = new ObjectMapper().writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("delete student")
    void removeStudentTest() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        Long id = studentDTO.getId();
        TestUtilsGenerator.appendNewStudent(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",id))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @DisplayName("Get all students")
    void listStudentTest() throws Exception{
        Set<StudentDTO> studentDTOSet = TestUtilsGenerator.getStudentSet();
        String jsonExpected = new ObjectMapper().writeValueAsString(studentDTOSet);
        studentDTOSet.forEach(TestUtilsGenerator::appendNewStudent);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(content().json(jsonExpected));
    }

}
