package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    //ES UN DESASTRE PORQUE AGARRA EL REPO Y LO MODIFICA CONSTANTE MENTE
    @Test
    void save() {
        //Agregar
            //sett
        StudentDAO dao =new StudentDAO();
        StudentDTO juan = new StudentDTO();
        juan.setId(1L);
        juan.setStudentName("Juan");
        juan.setSubjects(List.of(
                new SubjectDTO("Matemática", 9.00),
                new SubjectDTO("Física", 7.00),
                new SubjectDTO("Química", 6.00)
        ));
            //ARRANGE
        dao.save(juan);
            //Assert
        assertTrue(dao.exists(juan));
        //Modificar
        //sett
         dao =new StudentDAO();
         juan = new StudentDTO();
        juan.setId(1L);
        juan.setStudentName("carlitos");
        juan.setSubjects(List.of(
                new SubjectDTO("Matemática", 9.00),
                new SubjectDTO("Física", 7.00),
                new SubjectDTO("Química", 6.00)
        ));
        //ARRANGE
        dao.save(juan);
        //Assert
        assertTrue(dao.exists(juan));
    }

    @Test
    void delete() {
        //------------Feliz------------
        //set
        StudentDAO dao =new StudentDAO();
        boolean expected =true;

        //arrange
        boolean register= dao.delete(2L);
        //assert
        assertEquals(expected,register);
        //------------TRISTE------------
        //set
         dao =new StudentDAO();
         expected =false;

        //arrange
         register= dao.delete(128738127391872391L);
        //assert
        assertEquals(expected,register);
    }

    @Test
    void exists() {
        //set
        StudentDAO dao =new StudentDAO();
        boolean expected =true;
        StudentDTO juan = new StudentDTO();
        juan.setId(2L);
        juan.setStudentName("Juan");
        juan.setSubjects(List.of(
                new SubjectDTO("Matemática", 9.00),
                new SubjectDTO("Física", 7.00),
                new SubjectDTO("Química", 6.00)
        ));
        assertEquals(expected, dao.exists(juan));
        //set
            StudentDTO pepe = new StudentDTO();
            pepe.setId(123872893479821L);
            pepe.setStudentName("asdasdaasf");
            pepe.setSubjects(List.of(
                    new SubjectDTO("Matemática", 9.00),
                    new SubjectDTO("Física", 7.00),
                    new SubjectDTO("Química", 6.00)
            ));
            expected= false;
           StudentDAO daoxd =new StudentDAO();
           assertEquals(expected, daoxd.exists(pepe));


    }


    @Test
    void findById() {
        StudentDTO carlitos = new StudentDTO();
        carlitos.setId(9L);
        carlitos.setStudentName("carlitos");
        carlitos.setSubjects(List.of(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));

        StudentDAO dao =new StudentDAO();
        StudentDTO real= dao.findById(9L);
        assertEquals(real,carlitos);

    }
}