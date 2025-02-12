package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTests {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper;

    @BeforeEach
    public void SetUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void registerStudentTestOk() throws Exception{

        StudentDTO studentRequest = TestUtilsGenerator.getStudentWith3Subjects("Jose");
        String jsonBody = objectMapper.writeValueAsString(studentRequest);

        this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void registerStudentMalformedData() throws Exception {

        // Second data without coma.
        String jsonBody = "{\n" +
                "    \"id\": 2\n" +
                "    \"studentName\": \"Pedro\",\n" +
                "    \"message\": null,\n" +
                "    \"averageScore\": null,\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 10.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 8.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 4.0\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isBadRequest());

    }

    @Test
    public void registerStudentInvalidScore() throws Exception {

        // Score bigger than 10.
        String jsonBody = "{\n" +
                "    \"id\": 999,\n" +
                "    \"studentName\": \"Pedro\",\n" +
                "    \"message\": null,\n" +
                "    \"averageScore\": null,\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 10.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 500.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 4.0\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

        this.mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getStudentTestOk() throws Exception{
        this.mockMvc.perform(get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }

    @Test
    public void getStudentTestNoOk() throws Exception{
        this.mockMvc.perform(get("/student/getStudent/{id}",999))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void modifyStudentTestOk() throws Exception {
        String jsonBody = "{\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Cristian\",\n" +
                "    \"message\": null,\n" +
                "    \"averageScore\": null,\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matemática\",\n" +
                "        \"score\": 10.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Física\",\n" +
                "        \"score\": 5.0\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Química\",\n" +
                "        \"score\": 4.0\n" +
                "      }\n" +
                "    ]\n" +
                "  }";

        this.mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andDo(print())
                .andExpect(status().isOk());
    }




}
