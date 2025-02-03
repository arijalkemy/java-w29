package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    final static Long ID = 1L;
    final static String NAME = "Jhon";
    public static List<SubjectDTO> subjects;
    public static StudentDTO student;

    @BeforeEach
    void seTUp(){
        studentDAO = Mockito.spy(new StudentDAO());

        subjects = List.of(
                new SubjectDTO("Matematicas", 9.5),
                new SubjectDTO("Fisica", 9.6)
        );

        student = new StudentDTO(ID, NAME, "", 0.0, subjects);
    }

    @Test
    public void saveNewStudentTest(){
        studentDAO.save(student);

        StudentDTO obtained = studentDAO.findById(student.getId());

        Assertions.assertNotNull(obtained);
        Assertions.assertEquals(student, obtained);
        Assertions.assertEquals(ID, obtained.getId());
    }
}
