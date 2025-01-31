package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de controlador
// ObtenerDiplomaController, mockeando su dependencia con el servicio.
//Pasos del test Unitario con Mocks
//
//Crear el mock IObtenerDiplomaService
//Inyectarlo en ObtenerDiplomaController.
//Configurar su comportamiento (setup) con el método when.
//Realizar el test con un nombre de los casos borde, usar los asserts correspondientes.

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController diplomaControler;

    @Test
    void testAnlizeScoreById(){
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
        diplomaControler.analyzeScores(param);


        //assertions
        verify(service, times(1)).analyzeScores(param);
    }
}