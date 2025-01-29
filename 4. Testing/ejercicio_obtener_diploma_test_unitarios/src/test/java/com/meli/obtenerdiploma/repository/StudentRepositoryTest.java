package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRepositoryTest {

    private StudentDAO studentDAO = new StudentDAO();
    private StudentRepository studentRepository = new StudentRepository();

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void canNotCreateNewStudentDTOTest(){
        StudentDTO dto = new StudentDTO(3L, "", null, null, null);

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(dto);

        assertFalse(violations.isEmpty());
    }

    @Test
    public void canCreateNewStudentDTOTest(){
        List<SubjectDTO> subjectDTOs = new ArrayList<>();
        subjectDTOs.add(new SubjectDTO("Test", 7.0));
        StudentDTO dto = new StudentDTO(3L, "Juan", null, null, subjectDTOs);

        Set<ConstraintViolation<StudentDTO>> violations = validator.validate(dto);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void canSaveNewStudentDTOTest(){
        StudentDTO dto = new StudentDTO(3L, "Juan", null, null, null);

        studentDAO.save(dto);

        assertEquals(dto.getId(), studentDAO.findById(3L).getId());
        assertNotEquals("", studentDAO.findById(3L).getStudentName());
    }







}
