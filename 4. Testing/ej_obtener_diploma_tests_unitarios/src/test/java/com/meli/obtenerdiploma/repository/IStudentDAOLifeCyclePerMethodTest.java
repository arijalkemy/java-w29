package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class IStudentDAOLifeCyclePerMethodTest {

    private static IStudentDAO studentDAO;

    @BeforeAll
    static void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("save()")
    void testSave() {
        StudentDTO existingStudent = new StudentDTO();
        studentDAO.save(existingStudent);
        assertNotNull(existingStudent.getId(), "El ID no debe ser nulo después de guardar");
    }

    @Test
    @DisplayName("exists() with existing student")
    void testExists_whenExists_thenReturnTrue() {
        StudentDTO existingStudent = new StudentDTO();
        studentDAO.save(existingStudent);
        assertTrue(studentDAO.exists(existingStudent), "El estudiante debe existir después de ser guardado");
    }

    @Test
    @DisplayName("exists() with non existing student")
    void testExists_whenDoesntExists_thenReturnFalse() {
        StudentDTO nonExistingStudent = new StudentDTO();
        assertFalse(studentDAO.exists(nonExistingStudent),
                "El estudiante no debería existir si no ha sido guardado");
    }

    @Test
    @DisplayName("findById() with existing student")
    void testFindById_whenExists_thenReturnStudent() {
        StudentDTO existingStudent = new StudentDTO();
        studentDAO.save(existingStudent);
        StudentDTO result = studentDAO.findById(existingStudent.getId());
        assertEquals(existingStudent, result, String.format("El estudiante encontrado (%d) debe ser el mismo que el " +
                "guardado (%d)", existingStudent.getId(), result.getId()));
    }

    @Test
    @DisplayName("findById() with non existing student")
    void testFindById_whenDoesntExists_thenThrowStudentNotFoundException() {
        StudentDTO nonExistingStudent = new StudentDTO();
        assertThrows(StudentNotFoundException.class, () ->
                        studentDAO.findById(nonExistingStudent.getId()),
                "Debe lanzar excepción cuando el estudiante no exista"
        );
    }

    @Test
    @DisplayName("findAll() when list is not empty")
    @Disabled
    void testFindAll_whenListNotEmpty() {
    }

    @Test
    @DisplayName("findAll() when list is empty")
    @Disabled
    void testFindAll_whenListIsEmpty() {
    }

    @Test
    @Order(5)
    @DisplayName("delete() with existing student")
    void testDelete_ShouldRemoveStudent_WhenExists() {
        StudentDTO existingStudent = new StudentDTO();
        studentDAO.save(existingStudent);
        studentDAO.delete(existingStudent.getId());
        assertFalse(studentDAO.exists(existingStudent), String.format("El estudiante (%d) debería ser eliminado",
                existingStudent.getId()));

        assertThrows(StudentNotFoundException.class, () ->
                        studentDAO.findById(existingStudent.getId()),
                "Debería lanzar excepción cuando se busque el estudiante eliminado"
        );
    }

    @Test
    @DisplayName("delete() with non existing student")
    void delete_ShouldReturnFalse_WhenNotExists() {
        StudentDTO nonExistingStudent = new StudentDTO();
        assertFalse(studentDAO.delete(nonExistingStudent.getId()),
                "Debería devolver false si el estudiante no existe");
    }

}
