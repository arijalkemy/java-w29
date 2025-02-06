package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

  @Mock
  private IStudentDAO student_DAO;

  @InjectMocks
  private ObtenerDiplomaService obtenerDiplomaService;

  @Test
  void testAnalyzeScores() {
    //arrange
    StudentDTO student = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Test");
    //act
    when(this.student_DAO.findById(1L)).thenReturn(student);
    StudentDTO student_result = obtenerDiplomaService.analyzeScores(1L);
    verify(this.student_DAO, times(1)).findById(1L);
    //assert
    assertEquals(student_result.getAverageScore(), 9.0);
    assertEquals(student_result.getStudentName(), "Test");
  }
}
