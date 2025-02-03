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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private StudentDTO dto;

    @BeforeEach
    void init() {
        List<SubjectDTO> subjectDTOList = List.of(
                new SubjectDTO("Math", 8.0),
                new SubjectDTO("Science", 2.0)
        );
        dto = new StudentDTO(1L, "Julian", null, null, subjectDTOList);
    }

    @Test
    public void create() {
        // llamar al metodo del service
        studentService.create(dto);
        // verificar si el metodo del service llamó al method del dao encargado de crear
        verify(studentDAO).save(dto);
    }

    @Test
    public void read() {
        when(studentDAO.findById(1L)).thenReturn(dto);
        StudentDTO result = studentService.read(1L);
        assertEquals(result, dto);
        verify(studentDAO).findById(1L);
    }

    @Test
    public void update() {
        studentService.update(dto);
        verify(studentDAO).save(dto);
    }

    @Test
    public void delete() {
        studentService.delete(1L);
        verify(studentDAO).delete(1L);
    }

    @Test
    public void getAll() {
        Set<StudentDTO> methodReturn = new HashSet<>();
        when(studentRepository.findAll()).thenReturn(methodReturn);
        Set<StudentDTO> result = studentRepository.findAll();
        assertEquals(result, methodReturn);
        verify(studentRepository).findAll();
    }



}
