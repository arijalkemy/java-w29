package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    //crear un studiante

    @Test
    void createTest() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Pedro", "", 0.0, List.of());

        // Act
        studentService.create(student);

        // Assert
        verify(studentDAO, times(1)).save(student);

    }

    @Test
    void readTest() {
        //arrange
        StudentDTO studentDev = new StudentDTO(1L,"Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );
        Long param = 1L;

        //act
        when(studentDAO.findById(param)).thenReturn(studentDev);

        //assert
        assertEquals(studentDev,studentService.read(param));

    }

    @Test
    void readNotFoundTest() {
        //arrange
        Long param = 5L;

        //act
        when(studentDAO.findById(param)).thenThrow(StudentNotFoundException.class);

        //assert
        assertThrows(StudentNotFoundException.class,()-> studentService.read(param));

    }

    @Test
    void updateTest() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Pedro Juan", "", 0.0, List.of());

        // Act
        studentService.update(student);

        // Assert
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void deleteTest() {

        //arrange
        Long params = 1L;

        //act
        studentService.delete(params);

        //assertions
        verify(studentDAO,times(1)).delete(params);

    }

    @Test
    void getAll() {

        // Arrange
        Set<StudentDTO> students = Set.of(
                new StudentDTO(1L, "Juan", "", 0.0, List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física", 7.0),
                        new SubjectDTO("Química", 6.0)
                )),
                new StudentDTO(2L, "Pedro", "", 0.0, List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 8.0),
                        new SubjectDTO("Química", 4.0)
                )),
                new StudentDTO(3L, "Lucía", "", 0.0, List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física", 9.0),
                        new SubjectDTO("Química", 9.0)
                ))
        );



        //act

        when(studentRepository.findAll()).thenReturn(students);

        //assertions
        assertEquals(students,studentService.getAll());


    }
}