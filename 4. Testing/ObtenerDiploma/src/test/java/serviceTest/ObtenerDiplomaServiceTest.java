package serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO; // Mock del repositorio

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService; // La clase que vamos a probar

    private StudentDTO student; // Un estudiante de prueba
    private List<SubjectDTO> subjects; // Materias del estudiante

    @BeforeEach
    void setUp() {
        // Inicializar los mocks
        MockitoAnnotations.openMocks(this);

        // Crear un objeto de tipo StudentDTO y SubjectDTO para las pruebas
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matemáticas", 10.00),
                new SubjectDTO("Física", 8.00)
        );
        StudentDTO student = new StudentDTO(1L, "Juan Pérez", null, 0.0, subjects);
    }

    @Test
    void testCalculateAverage() {
        subjects = Arrays.asList(new SubjectDTO("Matemáticas", 10.00), new SubjectDTO("Física", 8.00));
        student = new StudentDTO(1L, "Juan Pérez", null, 0.0, subjects); // Asegúrate de asignar a la variable global
        // Definir el comportamiento esperado del mock
        when(studentDAO.findById(1L)).thenReturn(student);

        // Llamar al método que calcula el promedio
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);

        // Verificar que el promedio calculado es correcto
        assertEquals(9.0, result.getAverageScore(), 0.01);
    }

    @Test
    void testGreetingMessageHighScore() {
        // Configurar un estudiante con puntajes altos
        subjects = Arrays.asList(new SubjectDTO("Matemáticas", 10.0), new SubjectDTO("Física", 9.0));
        student = new StudentDTO(1L, "Carlos",null, 0.0, subjects);
        when(studentDAO.findById(1L)).thenReturn(student);

        // Verificar el mensaje de felicitación
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        String expectedMessage = "El alumno Carlos ha obtenido un promedio de 9,5. Felicitaciones!";
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    void testGreetingMessageLowScore() {
        // Configurar un estudiante con puntajes bajos
        subjects = Arrays.asList(new SubjectDTO("Matemáticas", 6.0), new SubjectDTO("Física", 7.0));
        student = new StudentDTO(1L, "Ana",null, 0.0, subjects);
        when(studentDAO.findById(1L)).thenReturn(student);

        // Verificar el mensaje indicando que puede mejorar
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        String expectedMessage = "El alumno Ana ha obtenido un promedio de 6,5. Puedes mejorar.";
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    void testEmptySubjects() {
        // Estudiante sin materias
        subjects = Arrays.asList();
        student = new StudentDTO(1L, "Luis",null, 0.0, subjects);
        when(studentDAO.findById(1L)).thenReturn(student);

        // Verificar que el promedio se maneja correctamente en este caso
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertTrue(result.getAverageScore().isNaN(), "El promedio debería ser NaN cuando no hay materias."); // El promedio debería ser nulo
    }

    @Test
    void testSingleSubject() {
        // Estudiante con solo una materia
        subjects = Arrays.asList(new SubjectDTO("Historia", 9.0));
        student = new StudentDTO(1L, "Pedro",null, 0.0, subjects);
        when(studentDAO.findById(1L)).thenReturn(student);

        // Verificar que el promedio se calcula correctamente
        StudentDTO result = obtenerDiplomaService.analyzeScores(1L);
        assertEquals(9.0, result.getAverageScore());
    }
}
