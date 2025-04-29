package com.meli.obtenerdiploma.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    IStudentService studentService;

    StudentDTO studentDTO;

    @BeforeEach
    void setUp(){
        studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Juan");
    }

    @Test
    void registerStudentTest() throws Exception {
        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        String studentJson = ow.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getStudentTest() throws Exception {
        when(studentService.read(9999L)).thenReturn(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 9999L)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(9999L))
                .andExpect(jsonPath("$.studentName").value("Juan"));

    }

    @Test
    void modifyStudentTest() throws Exception {
        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        String studentJson = ow.writeValueAsString(studentDTO);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void removeStudentTest() throws Exception {
        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void listStudentsTest() throws Exception {
        ObjectWriter ow = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}