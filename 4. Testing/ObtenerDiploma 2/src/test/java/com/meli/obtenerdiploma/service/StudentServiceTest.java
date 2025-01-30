package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    StudentDTO stu;
    Long studentID = 1L;


    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {


        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        );

        this.stu = new StudentDTO(studentID, "juan", null, null, subjects);
    }

    @Test
    void createTest() {
        studentService.create(this.stu);
        verify(studentDAO).save(this.stu);

    }

    @Test
    void readTest() {
        when(studentDAO.findById(studentID)).thenReturn(stu);
        StudentDTO expected = studentService.read(studentID);
        assertEquals(stu, expected);
    }

    @Test
    void updateTest() {
        studentService.update(this.stu);
        verify(studentDAO).save(this.stu);
    }

    @Test
    void deleteTest() {
        studentService.delete(studentID);
        verify(studentDAO).delete(studentID);
    }

    @Test
    void getAllTest() {
        // Arrange
        Set<StudentDTO> studentsResponse = new HashSet<>();
        studentsResponse.add(stu);

        // Act
        when(studentRepository.findAll()).thenReturn(studentsResponse);
        Set<StudentDTO> expected = studentService.getAll();

        // Assert
        assertEquals(studentsResponse, expected);

    }
}