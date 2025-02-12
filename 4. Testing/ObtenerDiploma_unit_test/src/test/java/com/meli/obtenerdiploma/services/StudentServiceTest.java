package com.meli.obtenerdiploma.services;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.swing.text.Utilities;

import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    @DisplayName("Create Student Test Ok")
    public void create(){
        // 🟢 **Arrange (Preparación)**
        StudentDTO studentDTOParam = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        //act
        studentService.create(studentDTOParam);
        //assert
        verify(studentDAO, atLeastOnce()).save(studentDTOParam);
    }

    @Test
    @DisplayName("Get Student By Id Test OK")
    public void read(){
        // Arrange
        Long studentIdParam = 1L;
        StudentDTO studentDTOExpected = TestUtilsGenerator.getStudentWithId(studentIdParam);
        StudentDTO studentDTOResponse = TestUtilsGenerator.getStudentWithId(studentIdParam);
        when(studentDAO.findById(studentIdParam)).thenReturn(studentDTOResponse);
        //Act and Asset
        Assertions.assertEquals(studentDTOExpected,studentService.read(studentIdParam));
    }

    @Test
    @DisplayName("Update Student Ok")
    public void update(){
        // Arrange
        StudentDTO studentDTOParam = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        //Act
        studentService.update(studentDTOParam);
        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTOParam);
    }


    @Test
    @DisplayName("Get All Students Ok")
    public void getAll(){
        //Arrange
        Set<StudentDTO> listStudentDTOExpected = TestUtilsGenerator.getStudentSet();
        Set<StudentDTO> listStudentDTOResponse = TestUtilsGenerator.getStudentSet();
        when(studentRepository.findAll()).thenReturn(listStudentDTOResponse);
        //Act and Assert
        Assertions.assertEquals(listStudentDTOExpected,studentService.getAll());
    }

    @Test
    @DisplayName("Delete Student OK")
    public void delete(){
        //Arrange
        Long studentIdParam = 1L;
        when(studentDAO.delete(studentIdParam)).thenReturn(true);
        //Act
        studentService.delete(studentIdParam);
        //Assert
        verify(studentDAO,atLeastOnce()).delete(studentIdParam);
    }



}
