package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    Set<StudentDTO> students;
    StudentDTO studentJuan;
    StudentDTO studentPedro;

    @BeforeEach
    void setUp() {
        students = new HashSet<>();

        SubjectDTO math = new SubjectDTO("Matematicas", 9.5);
        SubjectDTO literature = new SubjectDTO("Literatura", 8.8);
        SubjectDTO chemistry = new SubjectDTO("Química", 5.8);

        studentJuan = new StudentDTO(1L,
                "Juan",
                null,
                null, List.of(math, literature));

        studentPedro = new StudentDTO(2L,
                "Pedro",
                null,
                null, List.of(chemistry, math));

        students.add(studentJuan);
        students.add(studentPedro);

    }

    @Test
    void create(){
        // Arrange

        // Act
        studentService.create(studentPedro);

        // Assert
        verify(studentDAO, times(1)).save(studentPedro);
    }

    @Test
    void read(){
        // Arrange
        Long id = 1L;

        // Act
        when(studentDAO.findById(id)).thenReturn(studentJuan);
        StudentDTO expectedStudent = studentService.read(id);

        // Assert
        assertEquals(expectedStudent, studentJuan);
        assertEquals(expectedStudent.getId(), studentJuan.getId());
        assertEquals(expectedStudent.getAverageScore(), studentJuan.getAverageScore());
    }

    @Test
    void update(){
        studentService.update(studentJuan);

        verify(studentDAO, times(1)).save(studentJuan);
    }

    @Test
    void delete(){
        // Arrange
        Long id = 1L;
        // Act
        studentService.delete(id);
        // Assert
        verify(studentDAO, times(1)).delete(id);
    }

    @Test
    void getAll(){
        // Arrange

        // Act
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> expectedStudents = studentService.getAll();

        // Assert
        assertEquals(expectedStudents, students);
        assertEquals(expectedStudents.size(), students.size());
    }

}