package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentDAOTest {

    StudentDAO studentRepo = new StudentDAO();

    @Test
    public void saveTest(){
        StudentDTO student = new StudentDTO(
            1L, "Juan", "", 5.0, List.of(
                    new SubjectDTO("Matemática", 10.0)
        )
        );

        studentRepo.save(student);
        StudentDTO studentResult = studentRepo.findById(student.getId());

        Assertions.assertEquals(student, studentResult);
        Assertions.assertNotNull(studentResult);
    }

    @Test
    public void UpdateTest(){
        StudentDTO student = new StudentDTO(
                1L, "Juan", "", 5.0, List.of(
                new SubjectDTO("Matemática", 10.0)
        )
        );

        studentRepo.save(student);
        StudentDTO studentResult = studentRepo.findById(student.getId());

        studentResult.setStudentName("Mateo");
        studentRepo.save(studentResult);
        studentResult = studentRepo.findById(studentResult.getId());

        Assertions.assertEquals("Mateo", studentResult.getStudentName());
        Assertions.assertNotNull(studentResult);
    }

    @Test
    public void findByIdTest(){
        StudentDTO student = new StudentDTO(
                2L, "Juan", "", 5.0, List.of(
                new SubjectDTO("Matemática", 10.0)
        )
        );
        studentRepo.save(student);
        StudentDTO studentResult = studentRepo.findById(student.getId());

        Assertions.assertEquals(student.getId(), studentResult.getId());
        Assertions.assertNotNull(studentResult);
    }

    




}
