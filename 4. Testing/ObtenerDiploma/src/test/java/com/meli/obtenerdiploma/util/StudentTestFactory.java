package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public class StudentTestFactory {
    public static StudentDTO buildHighAverageStudent(Long id) {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 10.0),
                new SubjectDTO("Fisica", 9.5),
                new SubjectDTO("Quimica", 9.0)
        );
        return new StudentDTO(id, "Andres", null, null, subjects);
    }

    public static StudentDTO buildLowAverageStudent(Long id) {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 5.0),
                new SubjectDTO("Fisica", 4.5),
                new SubjectDTO("Quimica", 4.0)
        );
        return new StudentDTO(id, "Pepe", null, null, subjects);
    }

    public static StudentDTO buildStudentWithSubjects(Long id) {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematicas", 7.0),
                new SubjectDTO("Fisica", 6.5),
                new SubjectDTO("Quimica", 6.0)
        );
        return new StudentDTO(id, "John", null, null, subjects);
    }

    public static StudentDTO buildStudentWithNoId() {
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Lengua", 6.0),
                new SubjectDTO("Fisica", 6.0),
                new SubjectDTO("Quimica", 6.0)
        );
        return new StudentDTO(null, "Laura", null, null, subjects);
    }
}
