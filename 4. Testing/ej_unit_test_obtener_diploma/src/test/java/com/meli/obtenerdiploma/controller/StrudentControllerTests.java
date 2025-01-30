package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class StrudentControllerTests {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController controller;

    @Test
    public void successfulRegister(){
        // ARRANGE
        StudentDTO daniel = TestUtilsGenerator.getStudentWith3Subjects("Daniel");

        Mockito.doNothing().when(studentService).create(daniel);
        // ACT
        ResponseEntity<?> response = controller.registerStudent(daniel);
        // ASSERT
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void successfulDelete(){
        // ARRANGE
        Mockito.doNothing().when(studentService).delete(9999L);
        // ACT
        ResponseEntity<?> response = controller.removeStudent(9999L);
        // ASSERT
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void successfulGetAll(){
        // ARRANGE
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        Mockito.when(studentService.getAll()).thenReturn(students);
        // ACT
        Set<StudentDTO> controllerStudents = controller.listStudents();
        // ASSERT
        assertEquals(students, controllerStudents);
    }
}
