package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class StudentServiceTest {


    @Mock
    StudentRepository studentRepository;

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    StudentService studentService;

    @Test
    void create_test1() {
        //Arrange
        StudentDTO param = new StudentDTO(1000L, "silvia", "mensaje", 90.0,
                List.of(new SubjectDTO("Español", 90.0),
                        new SubjectDTO("Ingles", 80.0),
                        new SubjectDTO("Matematicas", 70.0)
                )
        );

        StudentDTO result = param;
        StudentDTO paramMock = param;
        //Act

        when(studentDAO.save(paramMock)).thenReturn(paramMock);

        var obtained_StudentDTO = studentService.create(param);
        //Assert

        Assertions.assertEquals(result, obtained_StudentDTO);

    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}