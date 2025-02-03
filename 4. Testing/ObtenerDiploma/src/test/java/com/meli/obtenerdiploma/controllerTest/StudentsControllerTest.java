package com.meli.obtenerdiploma.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentsControllerTest {

    final static Long ID = 1L;
    final static String NAME = "Jhon";
    public static List<SubjectDTO> subjects;
    public static StudentDTO student;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStudentService studentService;

    private ObjectMapper writer = new ObjectMapper();

    @BeforeAll
    public static void setUp(){
        subjects = List.of(
                new SubjectDTO("Matematicas", 9.5),
                new SubjectDTO("Fisica", 9.6)
        );

        student = new StudentDTO(ID, NAME, "", 0.0, subjects);
    }

    @Test
    public void registerStudentTest() throws Exception {
        Mockito.doNothing().when(studentService).create(student);

        String studentJson = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("")));
    }

    @Test
    public void getStudentTest() throws Exception {
        Mockito.when(studentService.read(ID)).thenReturn(student);

        mockMvc.perform(get("/student/getStudent/{id}", ID))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"));
    }

    @Test
    public void modifyStudentTest() throws Exception {
        Mockito.doNothing().when(studentService).update(student);

        String studentJson = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("")));
    }

    @Test
    public void removeStudentTest() throws Exception{
        Mockito.doNothing().when(studentService).delete(ID);
         mockMvc.perform(get("/student/removeStudent/{id}", ID))
                 .andExpect(status().isOk())
                 .andExpect(content().string(equalTo("")));
    }

    @Test
    public void listStudentsTest() throws Exception{
        StudentDTO student2 = new StudentDTO(2L, "Maria", "", 0.0, List.of(
                new SubjectDTO("Quimica", 9.5),
                new SubjectDTO("Biologia", 8.7)
        ));

        Set<StudentDTO> students = new HashSet<>();
        students.add(student);
        students.add(student2);

        Mockito.when(studentService.getAll()).thenReturn(students);

        mockMvc.perform(get("/student/listStudents")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2));
    }
}
