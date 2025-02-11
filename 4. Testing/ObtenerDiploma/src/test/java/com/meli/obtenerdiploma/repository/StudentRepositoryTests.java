package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class StudentRepositoryTests {

    IStudentRepository studentRepository;
    IStudentDAO studentDAO;
    private static final String FILE_PATH = "./src/test/resources/users.json";

    @BeforeEach
    public void setUp(){
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void findAllOkTest(){
        //Arrange
        Set<StudentDTO> studentDTOSet = TestUtilsGenerator.getStudentSet();
        studentDTOSet.stream().forEach(studentDTO -> studentDAO.save(studentDTO));
        //Act
        List<StudentDTO> studentDTOSetFound = new ArrayList<>(studentRepository.findAll());
        studentDTOSetFound.sort(Comparator.comparing(StudentDTO::getId));
        //Assert
        Assertions.assertArrayEquals(studentDTOSet.toArray(), studentDTOSetFound.toArray());
    }

    @Test void findAllNotFileExistExceptionTest(){
        //Arrange
        File file = new File(FILE_PATH);
        boolean fileExisted = file.exists();
        if (fileExisted) {
            assertTrue(file.delete(), "No se pudo eliminar el archivo de prueba");
        }
        //Assert and Act
        assertDoesNotThrow(() -> studentRepository.findAll());

        if (fileExisted) {
            try {
                assertTrue(file.createNewFile(), "No se pudo restaurar el archivo");
            } catch (Exception e) {
                fail("Error al restaurar el archivo después de la prueba.");
            }
        }
    }

    @Test void findAllIOExceptionTest() throws IOException {
        //Arrange
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write("{ invalidJson: ");
        writer.close();
        //Assert and Act
        assertDoesNotThrow(() -> studentRepository.findAll());
    }
}
