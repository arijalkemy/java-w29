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
    @DisplayName("save()")
    void testSave() {
        studentDAO.save(existingStudent);
        assertNotNull(existingStudent.getId(), "El ID no debe ser nulo después de guardar");
    }

    @Test
    @Order(2)
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
    @Order(3)
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
    @Order(4)
    @DisplayName("findAll() when list is not empty")
    @Disabled
    void testFindAll_whenListNotEmpty() {
        Set<StudentDTO> result = studentDAO.findAll();
        assertEquals(result, Set.of(existingStudent));
    }

    @Test
    @DisplayName("findAll() when list is empty")
    @Disabled
    @Order(6)
    void testFindAll_whenListIsEmpty() {
        Set<StudentDTO> result = studentDAO.findAll();
        assertEquals(0, result.size(), "El resultado debe ser 0 elementos");
    }

    @Test
    @Order(5)
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
