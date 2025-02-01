package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDaoTest {

    StudentDAO studentDAO = new StudentDAO();

//    public StudentDaoTest(StudentDAO studentDAO) {
//        this.studentDAO = studentDAO;
//    }

    @Test
    @DisplayName("Delete user - happy way")
    public void deleteoK(){
        //ARRANGE
        Long studentId = 1L;

        //act and asser
        Assertions.assertTrue(studentDAO.delete(studentId));
    }

    @Test
    @DisplayName("Delete user - sad way")
    public void deleteNotoK(){
        //ARRANGE
        Long studentId = 65L;

        //act and asser
        Assertions.assertFalse(studentDAO.delete(studentId));
    }
}
