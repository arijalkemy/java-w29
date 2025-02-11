package controller;


import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private StudentDTO student;

    @BeforeEach
    public void setUp() {
        // Configuración básica para los tests
        student = new StudentDTO(1L, "Juan Pérez", null, 8.5, null);
    }

    @Test
    public void testRegisterStudent() {
        // Arrange: Configuramos el mock para el método create del servicio
        doNothing().when(studentService).create(any(StudentDTO.class));

        // Act: Llamamos al controlador
        ResponseEntity<?> response = studentController.registerStudent(student);

        // Assert: Verificamos que se haya llamado al servicio correctamente y que la respuesta sea OK
        verify(studentService, times(1)).create(any(StudentDTO.class));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testGetStudent() {
        // Arrange: Configuramos el mock para el método read del servicio
        when(studentService.read(1L)).thenReturn(student);

        // Act: Llamamos al controlador
        StudentDTO response = studentController.getStudent(1L);

        // Assert: Verificamos que el servicio fue llamado correctamente y que la respuesta es la esperada
        verify(studentService, times(1)).read(1L);
        assertEquals("Juan Pérez", response.getStudentName());
        assertEquals(8.5, response.getAverageScore());
    }

    @Test
    public void testModifyStudent() {
        // Arrange: Configuramos el mock para el método update del servicio
        doNothing().when(studentService).update(any(StudentDTO.class));

        // Act: Llamamos al controlador
        ResponseEntity<?> response = studentController.modifyStudent(student);

        // Assert: Verificamos que el servicio fue llamado correctamente y que la respuesta sea OK
        verify(studentService, times(1)).update(any(StudentDTO.class));
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testRemoveStudent() {
        // Arrange: Configuramos el mock para el método delete del servicio
        doNothing().when(studentService).delete(1L);

        // Act: Llamamos al controlador
        ResponseEntity<?> response = studentController.removeStudent(1L);

        // Assert: Verificamos que el servicio fue llamado correctamente y que la respuesta sea OK
        verify(studentService, times(1)).delete(1L);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testListStudents() {
        // Arrange: Creamos una lista de estudiantes mockeada
        Set<StudentDTO> students = new HashSet<>();
        students.add(student);
        when(studentService.getAll()).thenReturn(students);

        // Act: Llamamos al controlador
        Set<StudentDTO> response = studentController.listStudents();

        // Assert: Verificamos que el servicio fue llamado correctamente y que la respuesta contiene los estudiantes
        verify(studentService, times(1)).getAll();
        assertEquals(1, response.size());
        assertTrue(response.contains(student));
    }
}

