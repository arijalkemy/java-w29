package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentDaoTest {

    StudentDAO studentDAO = new StudentDAO();

    @Test
    @DisplayName("Create user - happy way")
    public void saveOk(){
        //🟢 **Arrange (Preparación)**
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("lUIS");

        //🟡 **Act (Acción)**
        studentDAO.save(studentDTO);

        //🔴 **Assert (Verificación)**

        Assertions.assertTrue(studentDAO.exists(studentDTO));

    }

    @Test
    @DisplayName("Create user - happy way")
    public void saveOkWhenExistStudent(){
        //🟢 **Arrange (Preparación)**
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("lUIS");
        studentDAO.save(studentDTO);
        StudentDTO studentDTO2 = TestUtilsGenerator.getStudentWith3Subjects("lUIS");
        studentDTO2.setId(studentDTO.getId());

        //🟡 **Act (Acción)**
        studentDAO.save(studentDTO2);

        //🔴 **Assert (Verificación)**
        Assertions.assertTrue(studentDAO.exists(studentDTO2));

    }


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
