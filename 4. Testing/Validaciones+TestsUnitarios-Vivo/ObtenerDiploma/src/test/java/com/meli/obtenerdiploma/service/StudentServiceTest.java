package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create")
    void create(){
        //Arrange
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        //Act
        studentService.create(studentMock);
        //Assert
        verify(studentDAO, times(1)).save(studentMock);
    }

    @Test
    @DisplayName("Read")
    void read() {
        //Arrange
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        when(studentDAO.findById(3L)).thenReturn(studentMock);
        //Act
        StudentDTO result = studentService.read(3L);
        //Assert
        verify(studentDAO,times(1)).findById(3L);
        assertEquals(3l,studentService.read(3L).getId());

    }

    @Test
    @DisplayName("Update")
    void update(){
        //Arrange
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        //Act
        studentDAO.save(studentMock);
        //Assert
        verify(studentDAO,times(1)).save(studentMock);
    }

    @Test
    @DisplayName("Delete")
    void delete(){
        //Arrange
        StudentDTO studentMock = new StudentDTO(3L,"Nestor", "",0.0, List.of(
                new SubjectDTO("Lengua", 8.0),
                new SubjectDTO("Matematica", 8.0),
                new SubjectDTO("Fisica", 8.0)
        ));
        //Act
        studentDAO.delete(3L);
        //Assert
        verify(studentDAO,times(1)).delete(3L);
    }
    @Test
    @DisplayName("getAll")
    void getAll(){
        //Arrange
        Set<StudentDTO> studentsMock = Set.of(
                new StudentDTO(3L,"Nestor", "",0.0, List.of(
                        new SubjectDTO("Lengua", 8.0),
                        new SubjectDTO("Matematica", 8.0),
                        new SubjectDTO("Fisica", 8.0)
                )), new StudentDTO(4L,"Nestor", "",0.0, List.of(
                        new SubjectDTO("Lengua", 8.0),
                        new SubjectDTO("Matematica", 8.0),
                        new SubjectDTO("Fisica", 8.0)
                )));
        when(studentRepository.findAll()).thenReturn(studentsMock);
        //Act
        Set<StudentDTO> result = studentRepository.findAll();
        //Assert
        verify(studentRepository,times(1)).findAll();
        assertEquals(studentsMock, result);
    }
}
