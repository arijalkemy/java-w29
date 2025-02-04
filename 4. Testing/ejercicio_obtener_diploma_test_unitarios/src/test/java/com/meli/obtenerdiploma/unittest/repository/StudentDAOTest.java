package com.meli.obtenerdiploma.unittest.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    // TEST SIN MOCKS

    /*
    @Test
    void testSave() {
        // Datos de prueba
        StudentDTO student = new StudentDTO(1L, "Juan Pérez", 9.5, null, null);

        // Ejecutar método
        StudentDTO savedStudent = studentRepository.save(student);

        // Verificar que se guardó correctamente
        assertNotNull(savedStudent);
        assertEquals(student, savedStudent);

        // Verificar que está en el Set interno
        Set<StudentDTO> students = studentRepository.getStudents();
        assertTrue(students.contains(student));
    }
     */

    private StudentDAO studentDAO;
    private StudentRepository studentRepository;
    private StudentDTO s1;
    private StudentDTO s2;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
        studentRepository = new StudentRepository();
        s1 = new StudentDTO(1L, "Juan", null, null, List.of());
        s2 = new StudentDTO(2L, "Juan", null, null, List.of());
        StudentDAO.students.add(s1);
        StudentDAO.students.add(s2);
    }

    @Test
    @DisplayName("save Happy Path")
    public void save() {
        StudentDTO param = new StudentDTO(1L, "Juan", null, null, List.of());

        studentDAO.save(param);

        assertTrue(StudentDAO.students.contains(param)); // en realidad se llama al repo.findAll() pero tengo problemas con el json
    }

    @Test
    @DisplayName("findByID Happy Path")
    public void findByID() {
        Long idParam = 1L;
        StudentDTO mReturn = new StudentDTO(idParam, "Juan", null, null, List.of());
        assertEquals(studentDAO.findById(idParam), mReturn);
    }

    @Test
    @DisplayName("findByID Sad Path Throws Student Not Found Exception")
    public void findByIDThrowsStudentNotFoundException() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(54356L));
    }

    @Test
    @DisplayName("delete Happy Path")
    public void delete() {
        Long studentId = 2L;

        boolean result = studentDAO.delete(studentId);

        assertTrue(result);
        assertFalse(StudentDAO.students.contains(s2));
    }

    @Test
    @DisplayName("delete Sad Path Throws Student Not Found Exception")
    public void deleteThrowsStudentNotFoundException() {
        assertThrows(StudentNotFoundException.class, () -> studentDAO.delete(54356L));
    }

    @Test
    @DisplayName("exists Happy Path")
    public void exists() {
        StudentDTO param = new StudentDTO(1L, "Juan", null, null, List.of());

        boolean result = studentDAO.exists(param);

        assertTrue(result);
    }

    @Test
    @DisplayName("exists Sad Path Throws Student Not Found Exception")
    public void existsThrowsStudentNotFoundException() {
        StudentDTO param = new StudentDTO(54356L, "Juan", null, null, List.of());
        assertThrows(StudentNotFoundException.class, () -> studentDAO.exists(param));
    }



}
