import java.util.ArrayList;

public class TestUtils {
    public static StudentDTO getStudentWithGreatGrades() {
        return new StudentDTO(
            10L,
            "Bart Simpson",
            "El alumno Bart Simpson ha obtenido un promedio de 9,5. Felicitaciones!",
            9.5,
            List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("English", 9.0))
        );
    }

    public static StudentDTO getStudentWithMediocreGrades() {
        return new StudentDTO(
            11L,
            "Milhouse Van Houten",
            "El alumno Milhouse Van Houten ha obtenido un promedio de 6,5. Puedes mejorar.",
            6.5,
            List.of(new SubjectDTO("Math", 6.0), new SubjectDTO("English", 7.0))
        );
    }

    public static Long getIdFromStudentWithGreatGrades() {
        return getStudentWithGreatGrades().getId();
    }

    public static Long getIdFromStudentWithMediocreGrades() {
        return getStudentWithMediocreGrades().getId();
    }

    public static List<StudentDTO> getAllStudents() {
        List<StudentDTO> students = new ArrayList<>();
        students.add(getStudentWithGreatGrades());
        students.add(getStudentWithMediocreGrades());
        return students;
    }
}
