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

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("getAll students test")
    void testGetAll() {
        // Arrange
        Set<StudentDTO> expectedStudents = new HashSet<>();

        expectedStudents.add(new StudentDTO(1L, "Juan", null, null, null));

        expectedStudents.add(new StudentDTO(2L, "Ana", null, null, null));

        // Act
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        Set<StudentDTO> actualStudents = studentService.getAll();

        // Assert
        assertEquals(expectedStudents, actualStudents, "El conjunto de estudiantes no coincide con el esperado.");
    }

    @Test
    @DisplayName("delete student")
    void deleteStudent() {
        // Arrange
        Long existingId = 1L;

        // Act
        when(studentDAO.delete(existingId)).thenReturn(true);

        studentService.delete(existingId);

        // Assert
        verify(studentDAO, atLeastOnce()).delete(existingId);
    }

    @Test
    @DisplayName("update student")
    void updateStudent() {
        // Arrange
        StudentDTO studentToUpdate = new StudentDTO(1L, "Juan", null, null, null);

        // Act
        studentService.update(studentToUpdate);

        // Assert
        verify(studentDAO, atLeastOnce()).save(studentToUpdate);
    }

    @Test
    @DisplayName("read a student by id")
    void readStudent() {
        // Arrange
        Long existingId = 1L;

        StudentDTO student = new StudentDTO(1L, "Juan", null, null, null);

        //.Act
        when(studentDAO.findById(existingId)).thenReturn(student);

        var result = studentService.read(existingId);

        // Assert
        verify(studentDAO, atLeastOnce()).findById(existingId);
        assertEquals(result, student);
    }

    @Test
    @DisplayName("save student")
    void saveStudent() {
        // Arrange
        StudentDTO studentToSave = new StudentDTO(1L, "Juan", null, null, null);

        // Act
        studentService.create(studentToSave);

        // Assert
        verify(studentDAO, atLeastOnce()).save(studentToSave);
    }

}
