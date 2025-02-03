package com.meli.obtenerdiploma.unittest.service;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresReturnsStudentDTO() {
        Long studentId = 1L;
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Math", 8.0),
                new SubjectDTO("Science", 2.0)
        );
        StudentDTO methodReturn = new StudentDTO(studentId, "Juan", null, null, subjects);

        when(studentDAO.findById(anyLong())).thenReturn(methodReturn);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(studentId, result.getId());
        assertEquals(5.0, result.getAverageScore());
        assertNotNull(result.getMessage());
        verify(studentDAO).findById(studentId);
    }

    @Test // en este caso está mal xq el metodo del servicio no maneja la excepcion. lo hace el DAO.
    public void analyzeScoresThrowStudentNotFoundException() {
        Long studentId = 1L;

        when(studentDAO.findById(studentId)).thenThrow(new StudentNotFoundException(studentId)); // por lo general sería thenReturn(Optional.empty)

        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(studentId));

        verify(studentDAO).findById(studentId);
    }


}
