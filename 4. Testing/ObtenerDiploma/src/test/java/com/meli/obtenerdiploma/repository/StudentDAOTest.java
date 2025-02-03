package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    @InjectMocks
    private StudentDAO studentDAO;

    @Test
    void save() {
        // Arrange
        SubjectDTO math = new SubjectDTO("Matematicas", 9.5);
        SubjectDTO literature = new SubjectDTO("Literatura", 8.8);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(math);
        subjects.add(literature);

        StudentDTO newStudent = new StudentDTO(
                1L,
                "Juan Pérez",
                "Excelente trabajo",
                9.15,
                subjects
        );

        // Act
        studentDAO.save(newStudent);
        StudentDTO student = studentDAO.findById(newStudent.getId());

        // Assert
        assertNotNull(student, "El estudiante guardado no debería ser nulo");
        assertEquals(student.getId(), newStudent.getId());
        assertEquals(student.getStudentName(), newStudent.getStudentName());
    }
}
