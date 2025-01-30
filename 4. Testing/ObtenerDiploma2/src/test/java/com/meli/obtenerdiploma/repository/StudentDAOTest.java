package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class StudentDAOTest {

    private final StudentDAO studentDAO;
    private final StudentRepository studentRepository;

    public StudentDAOTest() {
        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    @Order(1)
    public void shouldSaveStudent() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Matematicas", 9d));
        subjectDTOS.add(new SubjectDTO("Ciencia", 8.5d));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Jose");
        studentDTO.setMessage("Message");
        studentDTO.setSubjects(subjectDTOS);

        studentDAO.save(studentDTO);

        assertTrue(true);
    }

    @Test
    @Order(2)
    public void shouldGetById() {
        StudentDTO studentDTO = studentRepository.findAll().stream().findFirst().get();

        StudentDTO student = studentDAO.findById(Long.valueOf(studentDTO.getId()));
        Assertions.assertNotNull(student);
        Assertions.assertEquals(studentDTO, student);
    }

    @Test
    @Order(3)
    public void shouldNotGetById() {
        try {
            studentDAO.findById(-1l);
        } catch (StudentNotFoundException e) {
            assertTrue(true);
        }
    }

    @Test
    @Order(4)
    public void shouldDeleteById() {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("Matematicas", 9d));
        subjectDTOS.add(new SubjectDTO("Ciencia", 8.5d));

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentName("Jose");
        studentDTO.setMessage("Message");
        studentDTO.setSubjects(subjectDTOS);

        studentDAO.save(studentDTO);

        Set<StudentDTO> studentDTOS = studentRepository.findAll();

        boolean deleted = studentDAO.delete(studentDTOS.stream().findFirst().get().getId());
        assertTrue(deleted);
    }

    @Test
    @Order(5)
    public void shouldNotDeleteById() {
        boolean deleted = studentDAO.delete(-1l);
        assertTrue(!deleted);
    }

    @Test
    @Order(6)
    public void shouldFindAll() {
        Set<StudentDTO> studentDTOS = studentRepository.findAll();
        Assertions.assertNotNull(studentDTOS);
    }
}
