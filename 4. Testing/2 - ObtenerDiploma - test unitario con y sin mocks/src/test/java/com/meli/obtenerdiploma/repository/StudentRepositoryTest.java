package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTest {

    StudentRepository studentRepository;

    public StudentRepositoryTest(){
        this.studentRepository = new StudentRepository();
    }
    @Test
    void findAllOKTest() {
        // arrange
        Integer expected = 3;
        // act
        Set<StudentDTO> loadedData = studentRepository.findAll();
        // assert
        assertEquals(expected, loadedData.size());
    }
}
