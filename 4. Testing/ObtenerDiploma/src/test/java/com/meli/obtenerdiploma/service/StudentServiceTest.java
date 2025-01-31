package com.meli.obtenerdiploma.service;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository repository;

    @InjectMocks
    StudentService service;

    @Test
    @DisplayName("Happy Path Create")
    void createTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        service.create(student);

        verify(studentDAO).save(student);
    }

    @Test
    @DisplayName("Happy Path findById")
    void findByIdTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO expected = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);
        when(studentDAO.findById(anyLong())).thenReturn(expected);

        StudentDTO result = service.read(2L);

        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Happy Path Update")
    void updateTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        service.update(student);

        verify(studentDAO).save(student);
    }

    @Test
    @DisplayName("Happy Path Delete")
    void deleteTest(){
        service.delete(1L);

        verify(studentDAO).delete(1L);
    }

    @Test
    @DisplayName("Happy Path Get All")
    void getAllTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);
        Set<StudentDTO> excpected = Set.of(student);
        when(repository.findAll()).thenReturn(excpected);

        var response = service.getAll();

        assertEquals(excpected, response);
    }
}
