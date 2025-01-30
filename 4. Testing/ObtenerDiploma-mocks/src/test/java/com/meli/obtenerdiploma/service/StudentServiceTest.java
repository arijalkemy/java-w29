package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private final Long USER_ID = 0L;
    private final String STUDENT_NAME = "Matías";
    private final String STUDENT_MESSAGE = "Mensaje descriptivo";
    private final Double STUDENT_AVG_SCORE = 5.0;

    private final List<SubjectDTO> SUBJECTS = List.of(
            new SubjectDTO("Subject 1", 2.0),
            new SubjectDTO("Subject 2", 8.0));

    private StudentDTO testStudent;
    private Set<StudentDTO> testStudents;

    @BeforeEach
    void setUp() {
        testStudent = new StudentDTO(USER_ID, STUDENT_NAME, STUDENT_MESSAGE, STUDENT_AVG_SCORE, SUBJECTS);
        testStudents = new HashSet<>();
        testStudents.add(testStudent);
    }

    @Test
    public void test_read() {
        // 1. Arrange
        Mockito.when(studentDAO.findById(USER_ID)).thenReturn(testStudent);

        // 2. Act
        StudentDTO result = studentService.read(USER_ID);

        // 3. Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(USER_ID, result.getId());
        Assertions.assertEquals(STUDENT_NAME, result.getStudentName());
        Mockito.verify(studentDAO).findById(USER_ID);
    }

    @Test
    public void test_getAll() {
        // Arrange
        Mockito.when(studentRepository.findAll()).thenReturn(testStudents);

        // Act
        Set<StudentDTO> result = studentService.getAll();

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.containsAll(testStudents));
        Assertions.assertTrue(testStudents.containsAll(result));
        Mockito.verify(studentRepository).findAll();
    }

}