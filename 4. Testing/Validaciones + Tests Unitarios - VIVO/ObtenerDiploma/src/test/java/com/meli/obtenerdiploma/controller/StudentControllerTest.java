package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void registerStudentTest(){

    }
}
