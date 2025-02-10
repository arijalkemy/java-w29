package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController controller;

    @Test
    public void successfulRegister(){
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("David");

        Mockito.doNothing().when(studentService).create(student);
        // Act
        ResponseEntity<?> response = controller.registerStudent(student);
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void successfulDelete(){
        // Arrange
        Mockito.doNothing().when(studentService).delete(9999L);
        // Act
        ResponseEntity<?> response = controller.removeStudent(9999L);
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void successfulGetAll(){
        // Arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        Mockito.when(studentService.getAll()).thenReturn(students);
        // Act
        Set<StudentDTO> controllerStudents = controller.listStudents();
        // Assert
        assertEquals(students, controllerStudents);
    }
}
