package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudenServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan Pérez");
        studentDTO.setSubjects(List.of(
                new SubjectDTO("Matemáticas", 9.0),
                new SubjectDTO("Historia", 8.0),
                new SubjectDTO("Ciencias", 10.0)
        ));
    }

    @Test
    void createTest() {
        doNothing().when(studentDAO).save(studentDTO);

        studentService.create(studentDTO);

        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void readTest() {
        Long id = 1L;
        when(studentService.read(id)).thenReturn(studentDTO);
        StudentDTO result = studentService.read(id);
        assertEquals(studentDTO, result);
    }

    @Test
    void updateTest() {
        String name = "Carolina";
        doNothing().when(studentDAO).save(studentDTO);
        studentDTO.setStudentName(name);
        studentService.update(studentDTO);

        assertEquals(name, studentDTO.getStudentName());
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    void deleteTest() {
        Long id = 1L;
        studentService.delete(id);
        verify(studentDAO, times(1)).delete(id);
    }


    @Test
    void findAllTest() {
        Set<StudentDTO> studentDTOSet = new HashSet<>(List.of(studentDTO));

        when(studentService.getAll()).thenReturn(studentDTOSet);
        assertEquals(studentDTOSet, studentService.getAll());
    }
}
