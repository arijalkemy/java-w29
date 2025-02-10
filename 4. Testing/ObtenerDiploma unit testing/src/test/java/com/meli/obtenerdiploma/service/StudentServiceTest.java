package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    StudentRepository repository;

    @InjectMocks
    StudentService service;

    @Test
    void createTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        service.create(student);

        Mockito.verify(studentDAO).save(student);
    }

    @Test
    void readTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);
        StudentDTO studentReturn = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        Mockito.when(studentDAO.findById(1L)).thenReturn(studentReturn);
        studentReturn = service.read(1L);

        Assertions.assertEquals(studentReturn, student);
    }

    @Test
    void updateTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        service.update(student);

        Mockito.verify(studentDAO).save(student);

    }

    @Test
    void deleteTest(){

        service.delete(1L);

        Mockito.verify(studentDAO).delete(1L);

    }

    @Test
    void getAllTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        Set<StudentDTO> expected = Set.of(student);

        Mockito.when(repository.findAll()).thenReturn(expected);
        Set<StudentDTO> obtained = service.getAll();

        Assertions.assertEquals(expected,obtained);

    }

}
