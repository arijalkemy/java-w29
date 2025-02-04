package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;

    @Test
    public void registerStudentTest(){
        StudentDTO studentDTOExpect = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        doNothing().when(studentService).create(studentDTOExpect);
        ResponseEntity<?> response = studentController.registerStudent(studentDTOExpect);
        assertEquals(200, response.getStatusCodeValue());
        verify(studentService, atLeastOnce()).create(studentDTOExpect);
    }

    @Test
    public void getStudentTest(){
        StudentDTO studentDTOExpect = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        when(studentService.read(studentDTOExpect.getId())).thenReturn(studentDTOExpect);
        StudentDTO response = studentController.getStudent(studentDTOExpect.getId());
        assertEquals(studentDTOExpect, response);
        verify(studentService, atLeastOnce()).read(studentDTOExpect.getId());
    }

    @Test
    public void ModifyStudentTest(){
        StudentDTO studentDTOExpect = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        doNothing().when(studentService).update(studentDTOExpect);
        ResponseEntity<?>  response = studentController.modifyStudent(studentDTOExpect);
        assertEquals(200, response.getStatusCodeValue());
        verify(studentService, atLeastOnce()).update(studentDTOExpect);
    }

    @Test
    public void removeStudentTest(){
        StudentDTO studentDTOExpect = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        doNothing().when(studentService).delete(studentDTOExpect.getId());
        ResponseEntity<?> response = studentController.removeStudent(studentDTOExpect.getId());
        assertEquals(200, response.getStatusCodeValue());
        verify(studentService, atLeastOnce()).delete(studentDTOExpect.getId());
    }

    @Test
    public void listStudentTest(){
        StudentDTO studentDTO1 = TestUtilsGenerator.getStudentWith3Subjects("Camilo1");
        StudentDTO studentDTO2 = TestUtilsGenerator.getStudentWith3Subjects("Camilo2");
        Set<StudentDTO> setStudentDTOExpect = Set.of(studentDTO1,studentDTO2);
        when(studentService.getAll()).thenReturn(setStudentDTOExpect);
        Set<StudentDTO>   response = studentController.listStudents();
        assertEquals(setStudentDTOExpect, response);
        verify(studentService, atLeastOnce()).getAll();
    }




}
