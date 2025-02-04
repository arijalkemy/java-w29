package serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO cloneStudent(StudentDTO student) {
        return new StudentDTO(
                student.getId(),
                student.getStudentName(),
                student.getMessage(),
                student.getAverageScore(),
                student.getSubjects()
        );
    }

    @Test
    public void shouldAnalyzeGreatScores() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO(
                10L,
                "Bart Simpson",
                "El alumno Bart Simpson ha obtenido un promedio de 9. Puedes mejorar.",
                9.0,
                List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("English", 8.0))
        );
        Mockito.when(studentDAO.findById(10L)).thenReturn(cloneStudent(expectedStudent));

        // Act
        StudentDTO actualStudent = obtenerDiplomaService.analyzeScores(10L);

        System.out.print(actualStudent.getMessage());
        System.out.print(expectedStudent.getMessage());

        // Assert
        Assertions.assertEquals(expectedStudent.getId(), actualStudent.getId());
        Assertions.assertEquals(expectedStudent.getStudentName(), actualStudent.getStudentName());
        Assertions.assertEquals(expectedStudent.getMessage(), actualStudent.getMessage());
        Assertions.assertEquals(expectedStudent.getAverageScore(), actualStudent.getAverageScore());
        Assertions.assertEquals(expectedStudent.getSubjects(), actualStudent.getSubjects());
    }

    @Test
    public void shouldAnalyzeMediocreScores() {
        // Arrange
        StudentDTO expectedStudent = new StudentDTO(
                11L,
                "Milhouse Van Houten",
                "El alumno Milhouse Van Houten ha obtenido un promedio de 6,5. Puedes mejorar.",
                6.5,
                List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("English", 7.0))
        );
        Mockito.when(studentDAO.findById(11L)).thenReturn(cloneStudent(expectedStudent));

        // Act
        StudentDTO actualStudent = obtenerDiplomaService.analyzeScores(11L);

        System.out.print(actualStudent.getMessage());
        System.out.print(expectedStudent.getMessage());

        // Assert
        Assertions.assertEquals(expectedStudent.getId(), actualStudent.getId());
        Assertions.assertEquals(expectedStudent.getStudentName(), actualStudent.getStudentName());
        Assertions.assertEquals(expectedStudent.getMessage(), actualStudent.getMessage());
        Assertions.assertEquals(expectedStudent.getAverageScore(), actualStudent.getAverageScore());
        Assertions.assertEquals(expectedStudent.getSubjects(), actualStudent.getSubjects());
    }

}
