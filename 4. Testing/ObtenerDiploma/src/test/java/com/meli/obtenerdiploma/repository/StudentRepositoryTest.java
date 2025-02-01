package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class StudentRepositoryTest {

    private StudentRepository studentRepository = new StudentRepository();

//    public StudentRepositoryTest(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Test
    @DisplayName("Find all students - Test Ok")
    public void findAll(){
        //arrange
        Set<StudentDTO> listStudentsdDtoExpected = TestUtilsGenerator.getStudentSet();
        //act
        Set<StudentDTO> listStudentsdDtoActual = studentRepository.findAll();

        //assert
        Assertions.assertEquals(listStudentsdDtoExpected, listStudentsdDtoActual);
    }
}
