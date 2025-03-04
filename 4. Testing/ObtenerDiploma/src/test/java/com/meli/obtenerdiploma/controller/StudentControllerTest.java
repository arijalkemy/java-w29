package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO student;
    private StudentDTO student2;

    @BeforeEach
    void setUp() {
        student = new StudentDTO(1L, "Juan Perez", "", 9.5,
                List.of(new SubjectDTO("Matemáticas", 10.0), new SubjectDTO("Historia", 9.0)));

        student2 = new StudentDTO(2L, "Juan Ramirez", "", 9.5,
                List.of(new SubjectDTO("Matemáticas", 10.0), new SubjectDTO("Historia", 9.0)));

    }

    @Test
    void getStudent() {
        when(studentService.read(1L)).thenReturn(student);
        StudentDTO result = studentController.getStudent(1L);
        assertNotNull(result);
        assertEquals("Juan Perez",result.getStudentName());
        verify(studentService).read(1L);
    }

    @Test
    void listStudents() {
        when(studentService.getAll()).thenReturn(Set.of(student,student2));
        Set<StudentDTO> result = studentController.listStudents();
        assertNotNull(result);
        assertEquals(2,result.size());
        verify(studentService).getAll();
    }
}