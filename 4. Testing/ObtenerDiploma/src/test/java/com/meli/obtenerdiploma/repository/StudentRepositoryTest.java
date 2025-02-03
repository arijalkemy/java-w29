package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Set;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@ExtendWith(SpringExtension.class)
public class StudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;


    @Test
    void givenStudentsInJson_whenFindAll_thenReturnStudentList() {
            Set<StudentDTO> students = studentRepository.findAll();
            assertEquals(2, students.size());
    }

}
