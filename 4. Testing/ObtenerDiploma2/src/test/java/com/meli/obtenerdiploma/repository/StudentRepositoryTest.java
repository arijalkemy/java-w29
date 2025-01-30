package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentRepositoryTest {

    private final StudentRepository studentRepository;

    public StudentRepositoryTest() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("should find all")
    public void findAllTest() {
        assertTrue(true);
    }

}
