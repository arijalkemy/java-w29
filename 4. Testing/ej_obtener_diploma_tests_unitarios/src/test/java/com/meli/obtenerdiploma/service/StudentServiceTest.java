package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Student service")
class StudentServiceTest {

    StudentDTO studentDTO = StudentDTO.builder().id(1L).build();

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create student")
    void testCreateStudent() {
        studentService.create(studentDTO);
        verify(studentDAO).save(studentDTO);
    }

    @Test
    @DisplayName("Read existing student")
    void testReadExistingStudent() {
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        assertEquals(studentDTO, studentService.read(studentDTO.getId()));
    }

    @Test
    @DisplayName("Read non existing student")
    void testReadNonExistingStudent() {
        when(studentDAO.findById(any(Long.class))).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class, () -> studentService.read(any(Long.class)));
    }

    @Test
    @DisplayName("Update student")
    void testUpdateExistingStudent() {
        studentService.update(studentDTO);
        verify(studentDAO).save(studentDTO);
    }

    @Test
    @DisplayName("Delete student")
    void testDeleteStudent() {
        studentService.delete(studentDTO.getId());
        verify(studentDAO).delete(studentDTO.getId());
    }

    @Test
    @DisplayName("Get all students")
    void testGetAllStudents() {
        studentService.getAll();
        verify(studentRepository).findAll();
    }
}