package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    IStudentRepository studentRepository;
    StudentDTO createStudentDTO;

    @BeforeEach
    public void setUp(){
        this.studentRepository = new StudentRepository();
        this.createStudentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
    }

    @Test
    public void findAllTestWhenFailLoadData(){
        Set<StudentDTO> findAll = studentRepository.findAll();
        assertNotNull(findAll);
        assertTrue(findAll.isEmpty());

    }

//    @Test
//    public void findAllTest(){
//        Set<StudentDTO> setExpect = new HashSet<>();
//        Set<StudentDTO> findAll = studentRepository.findAll();
//        assertEquals(setExpect, findAll);
//        assertFalse(findAll.isEmpty());
//    }


}
