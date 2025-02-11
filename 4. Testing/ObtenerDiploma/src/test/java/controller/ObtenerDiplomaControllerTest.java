package controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void obtenerDiploma() {
        // Arrange: Crear manualmente los datos de entrada
        Long studentId = 1L;  // ID del estudiante
        String studentName = "Marco";  // Nombre del estudiante

        // Crear las asignaturas manualmente
        // Suponiendo que SubjectDTO tiene un constructor que toma el nombre de la materia y la calificación
        SubjectDTO subject1 = new SubjectDTO("Matemáticas", 9.5);
        SubjectDTO subject2 = new SubjectDTO("Física", 8.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 7.5);

        // Crear el objeto StudentDTO manualmente, agregando las asignaturas
        StudentDTO stu = new StudentDTO(studentId, studentName, null, 8.33,  // Promedio ejemplo
                Arrays.asList(subject1, subject2, subject3));

        // Act: Llamar al método analyzeScores del controlador
        controller.analyzeScores(stu.getId());

        // Assert: Verificar que el servicio fue llamado al menos una vez con el ID correcto
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }
}
