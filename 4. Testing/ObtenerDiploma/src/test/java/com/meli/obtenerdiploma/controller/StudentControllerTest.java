package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService iStudentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    @DisplayName("Create Student Test OK")
    public void registerStudent(){
        //Arrange
        StudentDTO studentDTOParam = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        //Act
        studentController.registerStudent(studentDTOParam);
        //Assert
        verify(iStudentService,atLeastOnce()).create(studentDTOParam);
    }

    @Test
    @DisplayName("Get Student Test Ok")
    public void getStudent(){
        //Arrange
        Long studentIdParam = 1L;
        StudentDTO studentDTOExpected = TestUtilsGenerator.getStudentWithId(studentIdParam);
        StudentDTO studentDTOResponse = TestUtilsGenerator.getStudentWithId(studentIdParam);
        when(iStudentService.read(studentIdParam)).thenReturn(studentDTOResponse);
        //Act
        StudentDTO studentDTOActual = studentController.getStudent(studentIdParam);
        //Assert
        Assertions.assertEquals(studentDTOExpected,studentDTOActual);
    }

    @Test
    @DisplayName("Modify Student Test Ok")
    public void updateStudent(){
        //Arrange
        StudentDTO studentDTOParam = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        //Act
        studentController.modifyStudent(studentDTOParam);
        //Assert
        verify(iStudentService,atLeastOnce()).update(studentDTOParam);
    }

    @Test
    @DisplayName("Remove Student Test Ok")
    public void removeStudent(){
        //Arrange
        Long studentIdParam = 1L;
        //Act
        studentController.removeStudent(studentIdParam);
        //Assert
        verify(iStudentService,atLeastOnce()).delete(studentIdParam);
    }

    @Test
    @DisplayName("List Students Test Ok")
    public void listStudents(){
        //Arrange
        Set<StudentDTO> listStudentsDTOExpected = TestUtilsGenerator.getStudentSet();
        Set<StudentDTO> listStudentsDTOResponse = TestUtilsGenerator.getStudentSet();
        when(iStudentService.getAll()).thenReturn(listStudentsDTOResponse);
        //Act
        Set<StudentDTO> listStudentsDTOActual = studentController.listStudents();
        //Assert
        Assertions.assertEquals(listStudentsDTOExpected,listStudentsDTOActual);
    }
}
