package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentRepositoryTest {
    @Test
    public void findAllTest() {
        //Arrange
        Set<StudentDTO> expectedData = new HashSet<>();
        StudentRepository studentRepository = new StudentRepository();
        //Act
        Set<StudentDTO> loadedData = studentRepository.findAll();
        //Assert
        assertEquals(loadedData, expectedData);
    }
}
