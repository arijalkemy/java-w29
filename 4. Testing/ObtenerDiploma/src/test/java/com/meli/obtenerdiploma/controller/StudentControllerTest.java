package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentController.registerStudent(studentDTO);
        verify(studentService, atLeastOnce()).create(studentDTO);
    }
    @Test
    public void getStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);
        StudentDTO studentDTOFound = studentController.getStudent(studentDTO.getId());
        verify(studentService, atLeastOnce()).read(studentDTO.getId());
        Assertions.assertEquals(studentDTOFound, studentDTOFound);
    }
    @Test
    public void modifyStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentController.modifyStudent(studentDTO);
        verify(studentService, atLeastOnce()).update(studentDTO);
    }
    @Test
    public void removeStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentController.removeStudent(studentDTO.getId());
        verify(studentService, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    public void listStudents() {
        Set<StudentDTO> studentDTOSet = TestUtilsGenerator.getStudentSet();
        when(studentService.getAll()).thenReturn(studentDTOSet);

        Set<StudentDTO> studentDTOSetFound = studentController.listStudents();

        verify(studentService, atLeastOnce()).getAll();
        Assertions.assertEquals(studentDTOSet, studentDTOSetFound);
    }
}
