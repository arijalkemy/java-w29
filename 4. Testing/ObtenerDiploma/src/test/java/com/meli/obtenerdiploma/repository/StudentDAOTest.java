package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private StudentDAO studentDAO;
    @BeforeEach
    public void beforeEach(){
        studentDAO = new StudentDAO();
    }
    @Test
    public void save(){
        StudentDTO studentDTO = new StudentDTO();
        assertDoesNotThrow(()->studentDAO.save(studentDTO));
    }
    @Test
    public void saveExisting(){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(6L);
        studentDAO.save(studentDTO);
        assertDoesNotThrow(()->studentDAO.save(studentDTO));
    }
    @Test
    public void exists(){
        StudentDTO studentDTO = new StudentDTO();
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }
    @Test
    public void existsFalse(){
        StudentDTO studentDTO = new StudentDTO();
        assertFalse(studentDAO.exists(studentDTO));
    }
    @Test
    public void delete(){
        StudentDTO studentDTO = new StudentDTO();
    }
}