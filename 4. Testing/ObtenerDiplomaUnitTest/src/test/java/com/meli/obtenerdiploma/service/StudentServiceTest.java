package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @Test
    public void createTest(){
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("camilo");
        studentService.create(studentDTO);
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void readTest(){
        StudentDTO studentDTOExpected = TestUtilsGenerator.getStudentWith3Subjects("camilo");
        when(studentDAO.findById(studentDTOExpected.getId())).thenReturn(studentDTOExpected);
        StudentDTO studentDTO = studentService.read(studentDTOExpected.getId());
        verify(studentDAO, atLeastOnce()).findById(studentDTOExpected.getId());
        assertEquals(studentDTOExpected,studentDTO);

    }

    @Test
    public void updateTest(){
        StudentDTO studentDTOExpected = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        studentService.update(studentDTOExpected);
        when(studentDAO.findById(studentDTOExpected.getId())).thenReturn(studentDTOExpected);
        StudentDTO studentDTO = studentService.read(studentDTOExpected.getId());
        assertEquals(studentDTOExpected, studentDTO);
    }

    @Test
    public void deleteTest(){
        StudentDTO studentDTOExpected = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
        when(studentDAO.delete(studentDTOExpected.getId())).thenReturn(true);
        studentService.delete(studentDTOExpected.getId());
        verify(studentDAO, atLeastOnce()).delete(studentDTOExpected.getId());
    }

    @Test
    public void getAllTest(){
        StudentDTO studentDTO1 = TestUtilsGenerator.getStudentWith3Subjects("Camilo1");
        StudentDTO studentDTO2 = TestUtilsGenerator.getStudentWith3Subjects("Camilo2");
        Set<StudentDTO> setStudentDTOExpect = Set.of(studentDTO1,studentDTO2);
        when(studentRepository.findAll()).thenReturn(setStudentDTOExpect);
        Set<StudentDTO> setStudentDTO = studentService.getAll();
        verify(studentRepository, atLeastOnce()).findAll();
        assertEquals(setStudentDTOExpect, setStudentDTO);
    }



}
