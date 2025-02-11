package serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        // Inicializar los mocks
        MockitoAnnotations.openMocks(this);

        // Inicializar el objeto student
        StudentDTO student = new StudentDTO(1L, "Juan Pérez", null, 0.0, Arrays.asList(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Física", 8.0)
        ));
    }


    @Test
    void testCreateStudent() {
        // Crear un estudiante de prueba Arrange
        StudentDTO student = new StudentDTO(1L, "Juan Pérez", null, 0.0, Arrays.asList(
                new SubjectDTO("Matemáticas", 10.0),
                new SubjectDTO("Física", 8.0)
        ));

        // Llamar al método create  Act
        studentService.create(student);

        // Verificar que el método save del DAO fue llamado con el objeto correcto Assert
        verify(studentDAO).save(student); // Verifica que studentDAO.save() fue invocado con el objeto student
    }

    @Test
    void testReadStudentNotFound() {
        // Configurar el mock para devolver null si no encuentra el estudiante
        when(studentDAO.findById(1L)).thenReturn(null);

        // Llamar al método read
        StudentDTO result = studentService.read(1L);

        // Verificar que el resultado es null
        assertNull(result);

        // Verificar que el método findById fue llamado
        verify(studentDAO).findById(1L);
    }

    @Test
    void testReadStudentFound() {
        // Crear un estudiante simulado
        StudentDTO student = new StudentDTO(1L, "Juan", null, 0.0, new ArrayList<>());

        // Configurar el mock para devolver el estudiante simulado cuando se le pase el ID 1L
        when(studentDAO.findById(1L)).thenReturn(student);

        // Llamar al método read
        StudentDTO result = studentService.read(1L);

        // Verificar que el estudiante encontrado es el correcto
        assertNotNull(result);  // El resultado no debe ser nulo
        assertEquals(1L, result.getId());  // Verificar que el ID del estudiante es el esperado

        // Verificar que el método findById fue llamado exactamente una vez
        verify(studentDAO, times(1)).findById(1L);
    }

    @Test
    void testUpdateStudent() {
        // Arrange Crear un objeto de tipo StudentDTO para simular el estudiante
        StudentDTO student = new StudentDTO(1L, "Juan Pérez", null, 0.0, null);

        // Act Llamar al método update
        studentService.update(student);

        // Assert Verificar que el método save en el mock studentDAO ha sido invocado una vez
        // con el objeto student como argumento
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    public void testDelete() {
        Long studentId = 123L;

        // Actuar: Llamamos al método delete
        studentService.delete(studentId);

        // Verificar: Aseguramos que studentDAO.delete se llamó con el id correcto
        verify(studentDAO, times(1)).delete(studentId);
    }

    @Test
    public void testGetAll() {
        // Simulamos una lista de estudiantes
        Set<StudentDTO> loadedData = new HashSet<>();
        StudentDTO studentDTO = new StudentDTO(6L, "Joaquin", null, 0.0, new ArrayList<>());
        loadedData.add(studentDTO);

        // Hacemos que el método findAll() del repositorio retorne la lista simulada
        when(studentRepository.findAll()).thenReturn(loadedData);

        // Actuar: Llamamos al método getAll() de la clase StudentService
        Set<StudentDTO> result = studentService.getAll();

        // Verificar: Comparamos el conjunto esperado con el conjunto actual
        assertEquals(loadedData, result);  // Usamos assertEquals para comparar el esperado con el actual
    }
}
