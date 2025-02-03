package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("CU1 - Create student Ok")
    void createTestOk() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(25L);

        studentService.create(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("CU2 - Read student iformation Ok")
    void readTestOk() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(25L);
        StudentDTO response;

        when(studentDAO.findById(25L)).thenReturn(studentDTO);

        response = studentService.read(25L);

        assertEquals(response, studentDTO);
    }

    @Test
    @DisplayName("CU2 - Read student not found")
    void readTestNotFound() {
        when(studentDAO.findById(25L)).thenReturn(null);

        StudentDTO response = studentService.read(25L);

        assertNull(response);
    }

    @Test
    @DisplayName("CU3 - Update student information test ok")
    void updateTestOk() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("NombreNuevo");

        studentService.update(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    @DisplayName("CU4 - Delete student information test ok")
    void delete() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(15L);

        studentService.delete(15L);

        verify(studentDAO, times(1)).delete(15L);
    }

    @Test
    void getAll() {
        Set<StudentDTO> studentDTOS = new HashSet<>();
        studentDTOS.add(new StudentDTO(20L, "Nombre20", "Apellido20", 0.0, new ArrayList<>()));
        studentDTOS.add(new StudentDTO(21L, "Nombre21", "Apellido21", 0.0, new ArrayList<>()));
        studentDTOS.add(new StudentDTO(22L, "Nombre22", "Apellido22", 0.0, new ArrayList<>()));
        studentDTOS.add(new StudentDTO(23L, "Nombre23", "Apellido23", 0.0, new ArrayList<>()));

        when(studentRepository.findAll()).thenReturn(studentDTOS);

        Set<StudentDTO> response = studentService.getAll();

        assertNotNull(response);
        assertFalse(response.isEmpty());
        assertEquals(studentDTOS, response);
    }
}