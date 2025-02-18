package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("registerStudent")
    void registerStudent(){
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        studentController.registerStudent(studentMock);
        verify(studentService,times(1)).create(studentMock);
    }
    @Test
    @DisplayName("getStudent")
    void getStudent(){
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        when(studentService.read(3L)).thenReturn(studentMock);
        StudentDTO result = studentController.getStudent(3L);
        assertEquals(3L,result.getId());
    }

    @Test
    @DisplayName("modifyStudent")
    void modifyStudent(){
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        studentController.modifyStudent(studentMock);
        verify(studentService, times(1)).update(studentMock);
    }

    @Test
    @DisplayName("removeStudent")
    void removeStudent(){
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        studentController.removeStudent(3L);
        verify(studentService, times(1)).delete(3L);
    }

    @Test
    @DisplayName("listStudents")
    void listStudents(){
        Set<StudentDTO> studentsMock = Set.of(
                new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        )), new StudentDTO(4L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
                )));
        when(studentService.getAll()).thenReturn(studentsMock);
        Set<StudentDTO> result = studentController.listStudents();
        verify(studentService,times(1)).getAll();
        assertEquals(studentsMock, result);
    }

}
