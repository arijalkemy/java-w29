package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

  @Mock
  private IStudentService student_service;

  @InjectMocks
  private StudentController student_controller;

  @Test
  void testGetStudent() {

  }

  @Test
  void testListStudents() {

  }

  @Test
  void testModifyStudent() {

  }

  @Test
  void testRegisterStudent() {
    //arrange
    StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Teast");
    //act
    ResponseEntity<?> response = this.student_controller.registerStudent(student);
    //assert
    assertEquals(response, ResponseEntity.ok(null));
  }

  @Test
  void testRemoveStudent() {

  }
}
