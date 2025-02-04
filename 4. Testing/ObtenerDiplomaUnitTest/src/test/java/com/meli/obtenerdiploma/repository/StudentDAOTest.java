package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class StudentDAOTest {

    IStudentDAO studentDAO;
    StudentDTO createStudentDTO;

    @BeforeEach
    public void setUp(){
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
        this.createStudentDTO = TestUtilsGenerator.getStudentWith3Subjects("Camilo");
    }

    @Test
    public void createStudentTest(){
        //🟢act
        studentDAO.save(createStudentDTO);
        assertTrue(studentDAO.exists(createStudentDTO));
        assertEquals(1, createStudentDTO.getId());
        assertEquals(studentDAO.findById(createStudentDTO.getId()), createStudentDTO);
    }

    @Test
    public void createStudentIfAlreadyExistTest(){
        StudentDTO studentDTO1 = createStudentDTO;
        StudentDTO studentDTO2 = createStudentDTO;
        studentDAO.save(studentDTO1);
        studentDTO2.setId(studentDTO1.getId());
        studentDAO.save(studentDTO2);
        assertTrue(studentDAO.exists(studentDTO1));
        assertTrue(studentDAO.exists(studentDTO2));
        assertEquals(1, studentDTO1.getId());
        assertEquals(1, studentDTO2.getId());
    }

    @Test
    public void deleteStudentTest(){
        StudentDTO studentDTO = createStudentDTO;
        studentDAO.save(studentDTO);
        boolean deleteStudent = studentDAO.delete(studentDTO.getId());
        assertTrue(deleteStudent);
    }

    @Test
    public void deleteStudentIfNotExistTest(){
        StudentDTO studentDTO = createStudentDTO;
        boolean deleteStudent = studentDAO.delete(studentDTO.getId());
        assertFalse(deleteStudent);
    }

    @Test
    public void existStudentTest(){
        StudentDTO studentDTO = createStudentDTO;
        studentDAO.save(studentDTO);
        boolean existStudent = studentDAO.exists(studentDTO);
        assertTrue(existStudent);
    }

    @Test
    public void existStudentIfNotExistTest(){
        StudentDTO studentDTO = createStudentDTO;
        boolean existStudent = studentDAO.exists(studentDTO);
        assertFalse(existStudent);
    }

    @Test
    public void findByIdTest(){
        StudentDTO studentDTO = createStudentDTO;
        studentDAO.save(studentDTO);
        StudentDTO foundStudentDTO = studentDAO.findById(studentDTO.getId());
        assertEquals(studentDTO, foundStudentDTO);
    }
}
