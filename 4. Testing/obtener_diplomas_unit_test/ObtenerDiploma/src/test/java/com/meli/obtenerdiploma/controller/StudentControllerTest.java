package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


//Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de controlador
// StudentController, mockeando su dependencia con el servicio.
//Pasos del test Unitario con Mocks
//Crear el mock IStudentService
//Inyectarlo en StudentController.
//Configurar su comportamiento (setup) con el método when.
//Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController controller;

    @Test
    void registerStudent() {
        //arrange
        StudentDTO param = new StudentDTO(5L,"Pedro",
                "El alumno Pedro ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        //act
        controller.registerStudent(param);

        //assert
        verify(studentService,times(1)).create(param);
    }

    @Test
    void getStudent() {
        // arrange
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
        when(studentService.read(param)).thenReturn(studentDev);
        StudentDTO result = controller.getStudent(param);

        //assert
        assertEquals(studentDev,result);

    }

    @Test
    void modifyStudent() {
        //arrange
        StudentDTO param = new StudentDTO(1L,"Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 9.0),
                        new SubjectDTO("Física",7.0),
                        new SubjectDTO("Química", 6.0)
                )
        );

        //act
        controller.modifyStudent(param);

        //assert
        verify(studentService, times(1)).update(param);

    }

    @Test
    void removeStudent() {
        //arrange
        Long param=1L;

        //act
        controller.removeStudent(param);

        //assert
        verify(studentService,times(1)).delete(param);
    }

    @Test
    void listStudents() {
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
        when(studentService.getAll()).thenReturn(students);
        Set<StudentDTO> result = controller.listStudents();

        //assert
        assertEquals(students,result);
    }
}