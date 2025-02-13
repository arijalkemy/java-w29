package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.util.TestUtils;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void shouldCreateAStudent() {
        // Arrange
        StudentDTO savedStudent = TestUtils.getStudentWithGreatGrades();

        // Act
        studentService.create(savedStudent);

        // Assert
        Mockito.verify(studentDAO).save(savedStudent);
    }

    @Test
    public void shouldReadAStudent() {
        // Arrange
        StudentDTO expectedStudent = TestUtils.getStudentWithGreatGrades();

        Long enteredId = expectedStudent.getId();

        Mockito.when(studentDAO.findById(enteredId)).thenReturn(expectedStudent);
        // Act
        StudentDTO actualStudent = studentService.read(enteredId);

        // Assert
        Assertions.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void shouldUpdateAStudent() {
        // Arrange
        StudentDTO expectedStudent = TestUtils.getStudentWithGreatGrades();

        // Act
        studentService.update(savedStudent);

        // Assert
        Mockito.verify(studentDAO).save(savedStudent);
    }

    @Test
    public void shouldDeleteAStudent() {
        // Arrange
        Long enteredId = TestUtils.getIdFromStudentWithGreatGrades();

        // TODO: Should it return true?
        Mockito.when(studentDAO.delete(enteredId)).thenReturn(true);

        // Act
        studentService.delete(enteredId);

        // Assert
        Mockito.verify(studentDAO).delete(stu.getId());
    }

    @Test
    public void shouldGetAllStudents() {
        // Arrange
        List<StudentDTO> expectedStudents = TestUtils.getAllStudents();

        Mockito.when(studentRepository.findAll()).thenReturn(expectedStudents);
        
        // Act
        List<StudentDTO> receivedStudents = studentService.getAll();

        // Assert
        Assertions.assertEquals(expectedStudents, receivedStudents);
    }
}
