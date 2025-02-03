package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void createNonExistentStudent(){
        StudentDTO newStudent= TestUtilsGenerator.getStudentWith3Subjects("Marco");

        studentDAO.save(newStudent);

        Assertions.assertTrue(studentDAO.exists(newStudent));
        Assertions.assertEquals(1L, newStudent.getId());
        Assertions.assertEquals(studentDAO.findById(newStudent.getId()), newStudent);
    }

    @Test
    public void createExistentStudent(){
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        studentDAO.save(newStudent);

        Assertions.assertTrue(studentDAO.exists(newStudent));
        Assertions.assertEquals(1L, newStudent.getId());
        Assertions.assertEquals(studentDAO.findById(newStudent.getId()), newStudent);

    }

    @Test
    public void createTwoNonExistentStudents(){
        StudentDTO newStudent1 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        StudentDTO newStudent2 = TestUtilsGenerator.getStudentWith3Subjects("Andrés");

        studentDAO.save(newStudent1);
        studentDAO.save(newStudent2);

        Assertions.assertTrue(studentDAO.exists(newStudent1));
        Assertions.assertEquals(1L, newStudent1.getId());
        Assertions.assertEquals(studentDAO.findById(newStudent1.getId()), newStudent1);

        Assertions.assertTrue(studentDAO.exists(newStudent2));
        Assertions.assertEquals(2L, newStudent2.getId());
        Assertions.assertEquals(studentDAO.findById(newStudent2.getId()), newStudent2);
    }

    @Test
    public void findExistentStudent() {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentDAO.save(newStudent);

        StudentDTO studentDTOFound = studentDAO.findById(newStudent.getId());

        Assertions.assertEquals(newStudent, studentDTOFound);
    }

    @Test
    public void findNonExistentStudent(){
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(newStudent.getId()));
    }

    @Test
    public void modifyStudent(){
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentDAO.save(newStudent);

        newStudent.setStudentName("Andrés Largo");
        studentDAO.save(newStudent);

        StudentDTO studentDTOFound = studentDAO.findById(newStudent.getId());
        Assertions.assertEquals(newStudent.getStudentName(), studentDTOFound.getStudentName());
    }

    @Test
    public void deleteStudent(){
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Andrés");
        studentDAO.save(newStudent);

        studentDAO.delete(newStudent.getId());

        Assertions.assertFalse(studentDAO.exists(newStudent));
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(newStudent.getId()));

    }
}
