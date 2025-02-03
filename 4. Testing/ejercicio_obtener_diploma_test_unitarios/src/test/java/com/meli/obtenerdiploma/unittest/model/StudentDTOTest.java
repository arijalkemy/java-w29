package com.meli.obtenerdiploma.unittest.model;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDTOTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testSubjectDTOValidation() {
        // Crear un DTO con valores inválidos
        SubjectDTO invalidDTO = new SubjectDTO("", -1.0); // Nombre vacío y nota negativa

        // Validar el DTO
        Set<ConstraintViolation<SubjectDTO>> violations = validator.validate(invalidDTO);

        // Comprobar que hay errores de validación
        assertEquals(3, violations.size()); // Deberían ser 3 errores de validación
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("El nombre de la materia no puede estar vacío.")));
        assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("La nota mínima de la materia es de 0 pts.")));
    }

}
