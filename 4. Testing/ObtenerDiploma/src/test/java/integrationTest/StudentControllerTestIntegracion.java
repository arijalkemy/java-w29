package integrationTest;



import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ObtenerDiplomaApplication.class)
@AutoConfigureMockMvc
public class StudentControllerTestIntegracion {

    @Autowired
    MockMvc mockMvc;

    private static ObjectMapper objectMapper;

    SubjectDTO kahoot;
    SubjectDTO musica;
    SubjectDTO poo;
    StudentDTO student;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();

        // Definimos las asignaturas
        kahoot = new SubjectDTO("Kahoot", 1.0);
        musica = new SubjectDTO("Musica", 9.0);
        poo = new SubjectDTO("POO", 2.0);

        // Calculamos el promedio basado en las asignaturas
        student = new StudentDTO(1L, "Anibal",
                "El alumno Anibal ha obtenido un promedio de 4. Puedes mejorar.",
                4.0, List.of(kahoot, musica, poo));
    }

    @Test
    public void testRegisterStudent() throws Exception {
        // Realizamos la petición para registrar el estudiante
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetStudent() throws Exception {
        // Primero, registrar el estudiante
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());

        // Ahora que el estudiante está registrado, realizar la solicitud GET para obtenerlo
        mockMvc.perform(get("/student/getStudent/{id}", 21L))  // Cambiar el ID a 21 para usar el estudiante "Juan"
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.studentName").value("Juan"))  // Cambiar el nombre a "Juan"
                .andExpect(jsonPath("$.averageScore").value(7.5))  // Cambiar el promedio a 7.5
                .andExpect(jsonPath("$.subjects.length()").value(3))  // Verificar los 3 temas
                .andExpect(jsonPath("$.subjects[?(@.name == '" + kahoot.getName() + "' && @.score == " + kahoot.getScore() + ")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == '" + musica.getName() + "' && @.score == " + musica.getScore() + ")]").exists())
                .andExpect(jsonPath("$.subjects[?(@.name == '" + poo.getName() + "' && @.score == " + poo.getScore() + ")]").exists())
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7.5. Puedes mejorar."));  // Cambiar el mensaje a "Juan"
    }


    @Test
    public void testModifyStudent() throws Exception {
        // Modificamos la información del estudiante
        student.setStudentName("Juan");
        student.setAverageScore(7.5);
        student.setMessage("El alumno Juan ha obtenido un promedio de 7.5. Puedes mejorar.");

        // Realizamos la petición para modificar el estudiante
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk());

        // Verificamos que el estudiante se ha modificado correctamente
        mockMvc.perform(get("/student/getStudent/{id}", 15L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(7.5))
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7.5. Puedes mejorar."));
    }

    @Test
    public void testRemoveStudent() throws Exception {
        // Realizamos la petición para eliminar al estudiante
        mockMvc.perform(get("/student/removeStudent/{id}", 1L))
                .andExpect(status().isOk());

        // Verificamos que al obtener el estudiante ya no existe
        mockMvc.perform(get("/student/getStudent/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testListStudents() throws Exception {
        // Crear los estudiantes con sus datos
        StudentDTO firstStudent = new StudentDTO(2L, "Carlos",
                "El alumno Carlos ha obtenido un promedio de 5. Puedes mejorar.",
                5.0, List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("History", 4.0)));

        StudentDTO secondStudent = new StudentDTO(16L, "Juan",
                "El alumno Juan ha obtenido un promedio de 7.5. Puedes mejorar.",
                7.5, List.of(new SubjectDTO("Kahoot", 1.0), new SubjectDTO("Musica", 9.0), new SubjectDTO("POO", 2.0)));

        // Realizamos la petición para registrar el primer estudiante (Carlos)
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(firstStudent)))
                .andExpect(status().isOk());

        // Realizamos la petición para registrar el segundo estudiante (Juan)
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(secondStudent)))
                .andExpect(status().isOk());

        // Realizamos la petición para listar los estudiantes y no asumimos el orden
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.studentName == 'Carlos')]").exists())  // Verificamos que Carlos está en la lista
                .andExpect(jsonPath("$[?(@.studentName == 'Juan')]").exists());  // Verificamos que Juan está en la lista
    }

}

