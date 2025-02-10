package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Properties;
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
    public void unsuccessfulFindStudentById(){
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
            System.out.println("Not found resource");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error using JSON formatting");
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
            System.out.println("Not found resource");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error using JSON formatting");
        }

        return loadedData;
    }
}
