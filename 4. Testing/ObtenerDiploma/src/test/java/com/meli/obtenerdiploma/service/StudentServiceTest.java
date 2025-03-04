package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    //Ejercicio 3
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    private StudentDTO student;

    @InjectMocks
    StudentService studentService;

    @BeforeEach
    void setUp() {
        student = new StudentDTO(1L, "Juan Pérez", "", 8.5,
                List.of(new SubjectDTO("Matemáticas", 9.0)));
    }

    @Test
    void createTest() {
        studentService.create(student);
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void readWhenExistTest() {
        when(studentDAO.findById(1L)).thenReturn(student);

        StudentDTO result = studentService.read(1L);

        assertNotNull(result);
        assertEquals("Juan Pérez", result.getStudentName());
    }

    @Test
    void readWhenNotExistTest(){

        when(studentDAO.findById(99L)).thenThrow(new StudentNotFoundException(99L));

        assertThrows(StudentNotFoundException.class, () -> studentService.read(99L));
    }

    @Test
    void update() {
        studentService.update(student);
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void delete() {
        studentService.delete(1L);
        verify(studentDAO, times(1)).delete(1L);
    }

    @Test
    void getAll() {
        when(studentRepository.findAll()).thenReturn(Set.of(student));

        Set<StudentDTO> result = studentService.getAll();

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
    }
}