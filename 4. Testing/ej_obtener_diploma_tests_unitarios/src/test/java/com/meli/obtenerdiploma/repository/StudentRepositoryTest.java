package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    StudentRepository studentRepository = new StudentRepository();

    @Test
    void findAll() {
        assertNotNull(studentRepository.findAll());
    }
}