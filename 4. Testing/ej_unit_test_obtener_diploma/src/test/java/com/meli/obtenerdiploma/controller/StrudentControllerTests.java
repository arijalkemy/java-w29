package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StrudentControllerTests {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController controller;
}
