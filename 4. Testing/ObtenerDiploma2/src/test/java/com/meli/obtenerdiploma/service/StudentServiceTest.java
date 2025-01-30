package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Pepito");
        studentDTO.setSubjects(new ArrayList<>());

        studentService.create(studentDTO);

        verify(studentDAO).save(studentDTO);
    }

    @Test
    public void readByIdTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1l);
        studentDTO.setStudentName("Pepito");
        studentDTO.setSubjects(new ArrayList<>());

        when(studentDAO.findById(1l)).thenReturn(studentDTO);

        StudentDTO result = studentService.read(1l);

        assertEquals(studentDTO, result);
    }


}
