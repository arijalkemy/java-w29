package com.meli.obtenerdiploma.serviceTest;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // agregamos la clase
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService service;


    @Test
    @DisplayName("Happy Path Create")
    public void createOkTest(){
        //Arrenge
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);
        // act y assert
        service.create(student);
        verify(studentDAO).save(student); // verifica que paso por aca
    }

    @Test
    @DisplayName("Read student")
    void readExistingStudent(){
        //arrenge
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId,"Juan","Algo",7.8,new ArrayList<>());
        when(studentDAO.findById(studentId)).thenReturn(student);
        //act
        StudentDTO result = service.read(studentId);
        //assert
        assertEquals(student,result);
        verify(studentDAO).findById(studentId);//verifico que haya pasado pór aca
    }

    @Test
    @DisplayName("Exception not read student")
    void readException(){
        // arrenge
        Long studentId = 2L;
        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId));
        //act y assert
        assertThrows(StudentNotFoundException.class,()->{
            service.read(studentId);
        });
        verify(studentDAO).findById(studentId);//verifico que haya pasado pór aca

    }

    @Test
    @DisplayName("Update Happy")
    void updateTest(){
        //arrenge
        //StudentDTO student = new StudentDTO(1L,"Taiel","Cleiman",8.9,new ArrayList<>());
        StudentDTO student2 = new StudentDTO();
        doNothing().when(studentDAO).save(student2);
        //act
        service.update(student2);
        //assert
        verify(studentDAO).save(student2);
    }
    @Test
    @DisplayName("Delete Happy")
    void deleteOK(){
        //arrenge
        StudentDTO student2 = new StudentDTO();
        when(studentDAO.delete(1L)).thenReturn(true);
        //act
        service.delete(1L);
        //assert
        verify(studentDAO).delete(1L);
    }

    @Test
    @DisplayName("findAll Happy")
    void findAllOK(){
        //arrenge
        Set<StudentDTO> studentDTOList = new HashSet<>();
        when(studentRepository.findAll()).thenReturn(studentDTOList);
        //act,
        Set<StudentDTO> result = service.getAll();
        // assert
        assertEquals(studentDTOList,result);
        verify(studentRepository).findAll();
    }

}
