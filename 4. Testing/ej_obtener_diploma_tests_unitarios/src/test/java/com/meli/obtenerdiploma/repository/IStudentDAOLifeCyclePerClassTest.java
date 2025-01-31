package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.*;

import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Test Student DAO Lifecycle per class")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IStudentDAOLifeCyclePerClassTest {

    private IStudentDAO studentDAO;

    StudentDTO existingStudent = new StudentDTO();
    StudentDTO nonExistingStudent = new StudentDTO();

    @BeforeAll
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    @Order(1)
    @DisplayName("save() with non existing student")
    void testSaveNonExistingStudent() {
        studentDAO.save(existingStudent);
        assertNotNull(existingStudent.getId(), "El ID no debe ser nulo después de guardar");
    }

    @Test
    @Order(2)
    @DisplayName("save() with existing student")
    void testSaveExistingStudent() {
        Long id = existingStudent.getId();
        studentDAO.save(existingStudent);
        assertEquals(existingStudent.getId(), id, "El ID debe ser el mismo");
    }

    @Test
    @Order(3)
    @DisplayName("exists() with existing student")
    void testExists_whenExists_thenReturnTrue() {
        assertTrue(studentDAO.exists(existingStudent), "El estudiante debe existir después de ser guardado");
    }

    @Test
    @DisplayName("exists() with non existing student")
    void testExists_whenDoesntExists_thenReturnFalse() {
        assertFalse(studentDAO.exists(nonExistingStudent),
                "El estudiante no debería existir si no ha sido guardado");
    }

    @Test
    @Order(4)
    @DisplayName("findById() with existing student")
    void testFindById_whenExists_thenReturnStudent() {
        StudentDTO result = studentDAO.findById(existingStudent.getId());
        assertEquals(existingStudent, result, String.format("El estudiante encontrado (%d) debe ser el mismo que el " +
                "guardado (%d)", existingStudent.getId(), result.getId()));
    }

    @Test
    @DisplayName("findById() with non existing student")
    void testFindById_whenDoesntExists_thenThrowStudentNotFoundException() {
        assertThrows(StudentNotFoundException.class, () ->
                studentDAO.findById(nonExistingStudent.getId()),
                "Debe lanzar excepción cuando el estudiante no exista"
        );
    }

    @Test
    @DisplayName("findAll()")
    @Order(5)
    void testFindAll() {
        Set<StudentDTO> result = studentDAO.findAll();
        assertFalse(result.isEmpty(), "El resultado ser una lista con elementos");
    }

    @Test
    @Order(6)
    @DisplayName("delete() with existing student")
    void testDelete_ShouldRemoveStudent_WhenExists() {
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
        assertFalse(studentDAO.delete(nonExistingStudent.getId()),
                "Debería devolver false si el estudiante no existe");
    }
}
