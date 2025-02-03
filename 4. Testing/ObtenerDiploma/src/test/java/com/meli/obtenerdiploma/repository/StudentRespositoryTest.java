package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class StudentRespositoryTest {


    private IStudentDAO studentDAO;
    private IStudentRepository studentRepository;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    public void findAllStudents() {
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach(s -> studentDAO.save(s));

        List<StudentDTO> studentDTOSetFound = new ArrayList<>(studentRepository.findAll());
        studentDTOSetFound.sort(Comparator.comparing(StudentDTO::getId));

        Assertions.assertArrayEquals(students.toArray(), studentDTOSetFound.toArray());
    }
}
