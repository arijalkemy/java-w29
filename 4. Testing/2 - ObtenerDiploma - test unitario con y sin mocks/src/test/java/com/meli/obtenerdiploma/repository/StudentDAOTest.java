package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    public void init(){
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void saveNewStudentTest_ok(){
        // arrange
        Integer value = 3;
        // act
        this.studentDAO.save(new StudentDTO(
                3L,
                "Eliana",
                "Un mensaje",
                9.3,
                new ArrayList<>(List.of(new SubjectDTO("matematica", 5.4)))
        ));
        // assert
        assertEquals(value, studentDAO.getStudents().size());
    }

    @Test
    public void saveSameStudentTest_ok(){
        // arrange
        Integer value = 3;
        // act
        this.studentDAO.save(new StudentDTO(
                1L,
                "Eliana",
                "Un mensaje",
                9.3,
                new ArrayList<>(List.of(new SubjectDTO("matematica", 5.4)))
        ));
        // assert
        assertEquals(value, studentDAO.getStudents().size());
    }

    @Test
    public void deleteTest_ok(){
        // arrange
        Integer expectedSize = 3;
        // act
        boolean result = this.studentDAO.delete(3L);
        // assert
        assertEquals(expectedSize, this.studentDAO.getStudents().size());
        assertTrue(result);
    }

    @Test
    public void deleteStudentThatNotExistTest_ok(){
        // arrange
        Integer expectedSize = 3;
        // act
        boolean result = this.studentDAO.delete(5L);
        // assert
        assertEquals(expectedSize, this.studentDAO.getStudents().size());
        assertFalse(result);
    }
}
