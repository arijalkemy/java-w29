package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentRepositoryTests {
    private static StudentRepository repository;

    @BeforeAll
    public static void beforeAll(){
        TestUtilsGenerator.emptyUsersFile();
        repository = new StudentRepository();
    }

    @Test
    public void testFindAll(){
        // Arrange
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(4L);
        Set<StudentDTO> students = new HashSet<>(List.of(studentDTO));
        TestUtilsGenerator.appendNewStudent(studentDTO);
        // Act
        Set<StudentDTO> dbStudents = repository.findAll();
        // Assert
        assertEquals(dbStudents, students);
    }
}
