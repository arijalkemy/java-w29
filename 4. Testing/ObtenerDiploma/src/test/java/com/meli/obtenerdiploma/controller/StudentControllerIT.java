package com.meli.obtenerdiploma.controller;


import com.meli.obtenerdiploma.service.IStudentService;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(StudentController.class)
public class StudentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IStudentService studentService;
}
