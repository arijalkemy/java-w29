package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import java.util.List;

public class Datos {
    public static StudentDTO unEstudiante(){
        return new StudentDTO(1L, "Juan", List.of(new SubjectDTO("Math", 8.0), new SubjectDTO("History", 8.0)));
    }

    public static StudentDTO unEstudiante10() {
        return  new StudentDTO(1L, "Juan", List.of(new SubjectDTO("Math", 10.0), new SubjectDTO("History", 10.0)));

    }
}
