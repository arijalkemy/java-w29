package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    public StudentControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void getStudent() {
        Long studentId = 1L;
        StudentDTO dtoReturn = new StudentDTO(studentId, "Juan", null, null, List.of());
        when(studentService.read(studentId)).thenReturn(dtoReturn);
    }


    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return this.studentService.read(id);
    }


}
