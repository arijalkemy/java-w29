package com.meli.obtenerdiploma.service;
//Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de servicios
// ObtenerDiplomaService. Tener en cuenta múltiples escenarios y “casos borde” de cada comportamiento.
//
//Casos nulos, vacíos, inválidos.
//Datos de Salida idénticos a datos de Entrada.
//Cálculo del Promedio.
//Leyenda del Diploma.
//Mensaje de Diploma con Honores.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    public void analyzeScoreTest(){
        //arrange
        Long param = 1L;
        StudentDTO devolucion = new StudentDTO(1L,"Juan",
                "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.",
                7.333333333333333,
                List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física",7.0),
                new SubjectDTO("Química", 6.0)
                )
        );

        //act
        Mockito.when(studentDAO.findById(param)).thenReturn(devolucion);

        StudentDTO resultado = diplomaService.analyzeScores(param);

        //assertions

        assertEquals(devolucion.getStudentName(), resultado.getStudentName());
        assertEquals(devolucion.getMessage(), resultado.getMessage());
        assertEquals(devolucion.getAverageScore(), resultado.getAverageScore(), 0.01);
        assertEquals(devolucion.getSubjects().size(), resultado.getSubjects().size());
        assertEquals(devolucion.getSubjects(), resultado.getSubjects());

    }

    //diploma de honores
    @Test
    public void analyzeScoreHonoresTest(){
        //arrange
        Long param = 3L;
        StudentDTO devolucion = new StudentDTO(3L,"Lucía",
                "El alumno Lucía ha obtenido un promedio de 9,33. Felicitaciones!",
                9.333333333333333,
                List.of(
                        new SubjectDTO("Matemática", 10.0),
                        new SubjectDTO("Física",9.0),
                        new SubjectDTO("Química", 9.0)
                )
        );

        //act
        Mockito.when(studentDAO.findById(param)).thenReturn(devolucion);

        StudentDTO resultado = diplomaService.analyzeScores(param);

        //assertions

        assertEquals(devolucion.getStudentName(), resultado.getStudentName());
        assertEquals(devolucion.getMessage(), resultado.getMessage());
        assertEquals(devolucion.getAverageScore(), resultado.getAverageScore(), 0.01);
        assertEquals(devolucion.getSubjects().size(), resultado.getSubjects().size());
        assertEquals(devolucion.getSubjects(), resultado.getSubjects());

    }

}
