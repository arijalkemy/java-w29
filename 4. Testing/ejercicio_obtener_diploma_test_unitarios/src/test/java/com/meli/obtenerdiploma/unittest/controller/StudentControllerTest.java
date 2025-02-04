package com.meli.obtenerdiploma.unittest.controller;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {


    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudent(){
        StudentDTO param = new StudentDTO(1L, "Juan", null, null, List.of());

        ResponseEntity<?> response = studentController.registerStudent(param);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNull(response.getBody());
        verify(studentService).create(param);

    }

    @Test
    public void getStudent() {
        Long studentId = 1L;
        StudentDTO dtoReturn = new StudentDTO(studentId, "Juan", null, null, List.of());
        when(studentService.read(studentId)).thenReturn(dtoReturn);
        StudentDTO result = studentController.getStudent(studentId);
        assertEquals(dtoReturn, result);
        assertEquals(studentId, result.getId());
        verify(studentService).read(studentId);
    }

    @Test
    public void modifyStudent(){
        Long studentId = 1L;
        StudentDTO param = new StudentDTO(studentId, "Juan", null, null, List.of());

        ResponseEntity<?> response = studentController.modifyStudent(param);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNull(response.getBody());
        verify(studentService).update(param);
    }

    @Test
    public void removeStudent(){
        Long studentId = 1L;

        ResponseEntity<?> response = studentController.removeStudent(studentId);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertNull(response.getBody());
        verify(studentService).delete(studentId);
    }

    @Test
    public void listStudents(){
        Set<StudentDTO> mockStudents = new HashSet<>();
        mockStudents.add(new StudentDTO(1L, "Juan", null, null, List.of()));
        mockStudents.add(new StudentDTO(2L, "Maria", null, null, List.of()));

        when(studentService.getAll()).thenReturn(mockStudents);

        Set<StudentDTO> result = studentController.listStudents();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(s -> s.getStudentName().equals("Juan")));
        assertTrue(result.stream().anyMatch(s -> s.getStudentName().equals("Maria")));
        verify(studentService, times(1)).getAll();
    }





}
