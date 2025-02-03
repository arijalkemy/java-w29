package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.StudentTestFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
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
    void givenExistingStudentId_whenRead_thenReturnStudent() {
        Long studentId = 1L;
        StudentDTO student = StudentTestFactory.buildStudentWithSubjects(studentId);
        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = studentService.read(studentId);
        assertEquals(student, result);
        verify(studentDAO, times(1)).findById(studentId);
    }

    @Test
    void givenNonExistingStudent_whenRead_thenThrowException() {
        Long studentId = 99L;
        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));

        assertThrows(StudentNotFoundException.class, () -> studentService.read(studentId));

    }

    @Test
    void givenValidStudent_whenCreate_thenStudentIsSaved() {
        StudentDTO student = StudentTestFactory.buildStudentWithNoId();

        studentService.create(student);

        verify(studentDAO, times(1)).save(student);
    }


    @Test
    void givenUpdatedStudent_whenUpdate_thenStudentIsUpdated() {

        StudentDTO student = StudentTestFactory.buildStudentWithSubjects(1L);

        studentService.update(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void givenExistingUserId_whenDelete_thenStudentIsDeleted() {
        Long studentId = 1L;

        studentService.delete(studentId);

        verify(studentDAO, times(1)).delete(studentId);

    }

    @Test
    void givenNonExistingUserId_whenDelete_thenThrowException() {
        Long studentId = 99L;
        when(studentDAO.delete(studentId)).thenThrow(new StudentNotFoundException(studentId));

        assertThrows(StudentNotFoundException.class, () -> studentService.delete(studentId));
    }

    @Test
    void givenStudentsInRepository_whenGetAll_thenReturnAllStudents() {
        Set<StudentDTO> students = Set.of(
                StudentTestFactory.buildHighAverageStudent(1L),
                StudentTestFactory.buildLowAverageStudent(2L),
                StudentTestFactory.buildStudentWithSubjects(3L));

        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> resultStudents = studentService.getAll();

        assertEquals(3, resultStudents.size());
        assertEquals(students, resultStudents);
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void givenNoStudentsInRepository_whenGetAll_thenReturnEmptyStudents() {
        Set<StudentDTO> students = Set.of();
        when(studentRepository.findAll()).thenReturn(students);

        Set<StudentDTO> resultStudents = studentService.getAll();

        assertTrue(resultStudents.isEmpty());
        verify(studentRepository, times(1)).findAll();
    }
}
