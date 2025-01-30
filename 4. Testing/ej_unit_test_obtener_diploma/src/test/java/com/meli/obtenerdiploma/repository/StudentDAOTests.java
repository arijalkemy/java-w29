package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTests {

    private static StudentDAO studentDAO;
    private static Set<StudentDTO> students;

    @BeforeAll
    public static void beforeAll(){
        TestUtilsGenerator.emptyUsersFile();
        studentDAO = new StudentDAO();
    }

    @Test
    public void successfulSaveStudent(){
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Daniel");
        //ARRANGE
        //ACT
        studentDAO.save(newStudent);
        //ASSERT
        assertTrue(studentDAO.exists(newStudent));
    }

    @Test
    public void successfulFindStudentById(){
        //ARRANGE
        StudentDTO student = TestUtilsGenerator.getStudentWithId(1L);
        //ACT
        studentDAO.save(student);
        StudentDTO studentDTO = studentDAO.findById(1L);
        //ASSERT
        assertEquals(student, studentDTO);
    }

    @Test
    public void successfulDeleteStudent(){
        //ARRANGE
        StudentDTO student = TestUtilsGenerator.getStudentWithId(1L);
        //ACT
        studentDAO.save(student);
        studentDAO.delete(1L);
        //ASSERT
        assertFalse(studentDAO.exists(student));
    }

    @Test
    public void unsuccessfulFindStudentById(){
        //ARRANGE
        //ACT
        //ASSERT
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));
    }

    @AfterEach
    public void afterEach(){
        resetData();
    }

    private static void resetData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/test/resources/users.json");
            objectMapper.writeValue(file, students);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while writing to DB, check your JSON formatting.");
        }
    }

    private static Set<StudentDTO> loadData() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("./src/test/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }
}
