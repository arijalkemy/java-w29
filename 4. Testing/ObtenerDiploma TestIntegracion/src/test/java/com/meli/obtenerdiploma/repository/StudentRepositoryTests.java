package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentRepositoryTests {

    IStudentRepository studentRepo;
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepo = new StudentRepository();
    }

    @Test
    public void findAllExistentStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach((stu) -> studentDAO.save(stu));

        // act
        Set<StudentDTO> foundSet = studentRepo.findAll();

        // assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, foundSet));
    }

    @Test
    public void testFindAllWithFileNotFound() {
        // Cambia la variable SCOPE en el contexto del test para apuntar a un archivo inexistente
        String originalScope = StudentRepository.SCOPE;
        try {
            StudentRepository.SCOPE = "invalid";  // Asegúrate de que apunte a una ruta inválida

            Set<StudentDTO> result = studentRepo.findAll();

            // Si el archivo no existe realmente, el resultado debería ser un conjunto vacío
            assertTrue(result.isEmpty());

        } finally {
            // Restablece SCOPE a su valor original para no afectar otros tests
            StudentRepository.SCOPE = originalScope;
        }
    }

}
