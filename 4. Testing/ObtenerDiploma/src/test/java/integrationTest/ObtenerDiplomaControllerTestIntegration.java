package integrationTest;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.ObtenerDiplomaApplication;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ObtenerDiplomaApplication.class)
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    StudentDAO studentDAO;

    private static ObjectWriter writer;

    // Definir las materias
    SubjectDTO kahoot;
    SubjectDTO musica;
    SubjectDTO poo;

    @BeforeEach
    public void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        // Definir las materias
        kahoot = new SubjectDTO("Kahoot", 1.0);
        musica = new SubjectDTO("Musica", 9.0);
        poo = new SubjectDTO("POO", 2.0);

        // Crear el estudiante con las materias
        StudentDTO student = new StudentDTO(1L, "Anibal", "", 0.0, List.of(kahoot, musica, poo));

        // Calcular el promedio para el estudiante
        double averageScore = (kahoot.getScore() + musica.getScore() + poo.getScore()) / 3.0;
        student.setAverageScore(averageScore);

        // Generar el mensaje
        String message = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + String.format("%.2f", averageScore) + ". Puedes mejorar.";
        student.setMessage(message);

        // Guardar el estudiante en el DAO
        studentDAO.save(student);
    }

    @Test
    public void testGivenValidUserIdGetDiplomaWithAverageScore() throws Exception {

        // Definimos los datos para las materias del estudiante Carlos
        SubjectDTO math = new SubjectDTO("Math", 6.0);
        SubjectDTO history = new SubjectDTO("History", 4.0);

        // Realizamos la petición y validamos la respuesta
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2))  // ID de Carlos
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Carlos"))  // Validamos el nombre de estudiante
                .andExpect(jsonPath("$.averageScore").value(5))  // Validamos el promedio sin decimales
                .andExpect(jsonPath("$.subjects.length()").value(2))  // Validamos que hay 2 materias
                .andExpect(jsonPath("$.subjects[?(@.name == '" + math.getName() + "' && @.score == " + math.getScore() + ")]").exists())  // Validamos la materia Math
                .andExpect(jsonPath("$.subjects[?(@.name == '" + history.getName() + "' && @.score == " + history.getScore() + ")]").exists())  // Validamos la materia History
                .andExpect(jsonPath("$.message").value("El alumno Carlos ha obtenido un promedio de 5. Puedes mejorar."));  // Validamos el mensaje del estudiante Carlos
    }



    @Test
    void testGivenAnInvalidStudentIdThrowExceptionMessage() throws Exception {
        // Realizamos la petición para un ID que no existe
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 999))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }
}
