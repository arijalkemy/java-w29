package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceUnitTest {

    @Mock
    StudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Should create a student test")
    public void shouldCreateStudentTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Jose");

        // Act
        studentService.create(studentDTO);

        // Assert
        verify(studentDAO).save(studentDTO);
    }

    @Test
    @DisplayName("Should retrieve a student by it's id test")
    public void shouldRetrieveStudentTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Jose");
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        // Act
        StudentDTO result = studentService.read(studentDTO.getId());

        // Assert
        assertEquals(studentDTO, result);
    }

    @Test
    @DisplayName("Should update a student test")
    public void shouldUpdateStudentTest() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");

        // Act
        studentService.create(studentDTO);

        // Assert
        verify(studentDAO).save(studentDTO);
    }

    @Test
    @DisplayName("Should delete a student test")
    public void shouldDeleteStudentTest() {
        // Arrange
        Long studentId = 1L;

        // Act
        studentService.delete(studentId);

        // Assert
        verify(studentDAO).delete(studentId);
    }

    @Test
    @DisplayName("Should list all students test")
    public void shouldListAllStudentsTest() {
        // Arrange
        when(studentRepository.findAll()).thenReturn(Set.of());

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        assertTrue(result.isEmpty());
        verify(studentRepository).findAll();
    }

}
