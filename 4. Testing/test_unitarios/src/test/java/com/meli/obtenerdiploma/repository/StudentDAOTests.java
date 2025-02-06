package com.meli.obtenerdiploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;

public class StudentDAOTests {
  StudentDAO student_DAO;

  @Test
  void testDelete() {

  }

  @Test
  void testExists() {

  }

  @Test
  void testFindById() {

  }

  @Test
  void testSave() {
    //Arrange
    StudentDTO student = TestUtilsGenerator.getStudentWithId(1l);
    //Act
    this.student_DAO.save(student);
    //Assert
    assertTrue(student_DAO.exists(student));
  }

  @Test
  void testExistingSave() {
    //Arrange
    StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Test");
    //Act
    this.student_DAO.save(student);
    this.student_DAO.save(student);
    //Assert
    assertEquals(this.student_DAO.findById(1l), student);
  }

  @BeforeEach
  void setUp() {
    TestUtilsGenerator.emptyUsersFile();
    this.student_DAO = new StudentDAO();
  }
}
