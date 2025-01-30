package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    private static IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService service;

    @BeforeAll
    public static void beforeAll(){
        studentDAO = new StudentDAO();
    }

    @Test
    public void successfulCreate(){
        // ARRANGE
        StudentDTO daniel = TestUtilsGenerator.getStudentWith3Subjects("Daniel");

        Mockito.doNothing().when(studentDAO).save(daniel);
        Mockito.when(studentDAO.findById(any())).thenReturn(daniel);
        // ACT
        service.create(daniel);
        // ASSERT
        assertEquals(daniel, service.read(9999L));
    }

    @Test
    public void successfulDelete(){
        // ARRANGE
        Mockito.when(studentDAO.delete(any())).thenReturn(false);
        Mockito.when(studentDAO.findById(any())).thenThrow(StudentNotFoundException.class);
        // ACT
        service.delete(9999L);
        // ASSERT
        assertThrows(StudentNotFoundException.class, () -> service.read(9999L));
    }

    @Test
    public void successfulGetAll(){
        // ARRANGE
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        // ACT
        Set<StudentDTO> serviceStudents = service.getAll();
        // ASSERT
        assertEquals(students, serviceStudents);
    }
}
