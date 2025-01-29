package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
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
        // ARRANGE
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);
        Set<StudentDTO> students = new HashSet<>(List.of(studentDTO));
        TestUtilsGenerator.appendNewStudent(studentDTO);
        // ACT
        Set<StudentDTO> dbStudents = repository.findAll();
        // ASSERT
        assertEquals(dbStudents, students);
    }
}
