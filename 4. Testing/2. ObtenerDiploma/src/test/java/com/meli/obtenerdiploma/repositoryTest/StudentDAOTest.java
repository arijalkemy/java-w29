package com.meli.obtenerdiploma.repositoryTest;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private static IStudentDAO studentDAO;

    @BeforeAll
    public static void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("US1 - Save student happy path")
    public void saveStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDAO.save(studentDTO);

        assertNotNull(studentDTO);
    }

    @Test
    @DisplayName("US1 - Save student updating existent id")
    public void updateStudentTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDAO.save(studentDTO);
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Materia1", 2.0));
        subjectDTOS.add(new SubjectDTO("Materia2", 3.0));
        StudentDTO studentDTO2 = new StudentDTO(2L, "Nombre", "Apellido", 3.0, subjectDTOS);

        studentDAO.save(studentDTO2);

        StudentDTO findStudent = studentDAO.findById(2L);
        assertNotNull(findStudent);
        assertEquals(studentDTO2, findStudent);
    }

    @Test
    @DisplayName("US2 - Delete student happy path")
    public void deleteStudent() {
        StudentDTO studentDTO = new StudentDTO(11L, null, null, null, null);
        studentDAO.save(studentDTO);

        boolean result = studentDAO.delete(11L);

        assertTrue(result);
    }

    @Test
    @DisplayName("US2 - Delete student that doesn´t exists")
    public void deleteNonExistentStudent() {
        Long idToDelete = 15L;

        boolean result = studentDAO.delete(idToDelete);

        assertFalse(result);
    }

    @Test
    @DisplayName("US3 - Validate if student exists happy path")
    public void existStudentTestOk() {
        StudentDTO studentDTO = studentDAO.findById(1L);
        boolean existsResult;

        existsResult = studentDAO.exists(studentDTO);

        assertTrue(existsResult);
    }

    @Test
    @DisplayName("US3 - Validate if student does not exists")
    public void existStudentTestNotFound() {
        StudentDTO studentDTO = new StudentDTO(20L, null, null, null, null);
        boolean existsResult;

        existsResult = studentDAO.exists(studentDTO);

        assertFalse(existsResult);
    }

    @Test
    @DisplayName("US4 - Find student by ID happy path")
    public void findStudentByIdOkTest() {
        Long studentId = 1L;
        StudentDTO studentDTO;

        studentDTO = studentDAO.findById(studentId);

        assertNotNull(studentDTO);
        assertEquals(studentId, studentDTO.getId());
    }

    @Test
    @DisplayName("US4 - Find student by ID not found exception")
    public void findStudentByIdNotFoundTest() {
        Long studentId = 20L;

        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(studentId));
    }
}
