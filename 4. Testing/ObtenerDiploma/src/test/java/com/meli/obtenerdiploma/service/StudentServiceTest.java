package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest(){
        StudentDTO student = new StudentDTO();

        studentService.create(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void readTest(){
        Long id = 1L;

        studentService.read(id);

        verify(studentDAO, times(1)).findById(id);
    }

    @Test
    public void updateTest(){
        StudentDTO student = new StudentDTO();

        studentService.update(student);

        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void deleteTest(){
        Long id = 1L;

        studentService.delete(id);

        verify(studentDAO, times(1)).delete(id);
    }

    @Test
    public void getAllTest(){
        studentService.getAll();
        verify(studentRepository, times(1)).findAll();
    }
}
