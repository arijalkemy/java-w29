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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAO;
    @Mock
    IStudentRepository iStudentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("US1 - Happy Path")
    void readOKTest(){
        // arrange
        // objeto de entrada y objeto de salida
        Long id = 2L;
        StudentDTO studentDTOMock = new StudentDTO(
                2L,
                "Eliana",
                "mensaje",
                9.4,
                new ArrayList<>(new ArrayList<>(List.of(new SubjectDTO("matematica", 5.4)))));
        when(iStudentDAO.findById(id)).thenReturn(studentDTOMock);

        // act
        // llamado al método
        StudentDTO actual = studentService.read(id);

        // assert
        assertEquals(studentDTOMock, actual);

    }

    @Test
    @DisplayName("US1 - Throw not found exception")
    void getClientByNameThrowNotFoundTest(){

    }
}
