package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void createStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentDTO.setId(1L);
        studentService.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
        assertEquals(1L, studentDTO.getId());
    }

    @Test
    public void readStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        studentService.read(studentDTO.getId());

        verify(studentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals(studentDTO, studentDTO);
    }

    @Test
    public void updateStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentDTO.setId(1L);
        studentService.create(studentDTO);

        studentDTO.setStudentName("Andrés Largo");
        studentService.update(studentDTO);

        verify(studentDAO, times(2)).save(studentDTO);
        assertEquals("Andrés Largo", studentDTO.getStudentName());
    }

    @Test
    public void deleteStudent() {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentDTO.setId(1L);
        studentService.create(studentDTO);

        studentService.delete(studentDTO.getId());

        verify(studentDAO, atLeastOnce()).save(studentDTO);
        verify(studentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    public void getAllStudents() {
        //TODO: Hacer funcionar el repo
    }
}
