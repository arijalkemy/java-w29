package com.meli.obtenerdiploma.repositoryTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {
    private StudentRepository repository;

    @BeforeEach //inicializamos los datos de prueba
    public void setUp() {

    }

   /*@Test
    //Agregar un alumno.
    public void saveTest(){
        //Arrenge
        List<SubjectDTO> subjecs = new ArrayList<>();
        SubjectDTO subjet = new SubjectDTO("Matematica", 7.5);
        SubjectDTO subjet2 = new SubjectDTO("Lengua", 4.5);
        SubjectDTO subjet3= new SubjectDTO("Historia", 5.5);
        subjecs.add(subjet);
        subjecs.add(subjet2);
        subjecs.add(subjet3);
        StudentDTO student = new StudentDTO(1L,"Juan","Hola",2.5, subjecs);
        //Act
        studentDAO.save(student);
        //Assert
        assertTrue(studentDAO.exists(student));
    }

    //Buscar un alumno por Id.
    @Test
    public void findByIdTest(){
        //Arrenge
        StudentDTO student = new StudentDTO(1L,"Juan","Hola",2.5,new ArrayList<>());
        //ACT
        StudentDTO foundStudent = studentDAO.findById(student.getId());
        //Assert
        assertEquals(student.getId(),foundStudent.getId());
    }

    @Test
    public void findByIdSadTest(){
        StudentDTO student = new StudentDTO(1L,"Juan","Hola",2.5, new ArrayList<>());
        studentDAO.save(student);
        StudentNotFoundException exception = assertThrows(
                StudentNotFoundException.class,
                () -> studentDAO.findById(5L)
        );
        // Assert
        assertEquals("El alumno con Id " + 5L + " no se encuetra registrado.", exception.getMessage());

    }*/

    //Ejercicio2
    /*
    Se requiere crear los tests unitarios necesarios para cubrir el comportamiento de la capa de servicios
    ObtenerDiplomaService. Tener en cuenta múltiples escenarios y “casos borde” de cada comportamiento.

        Casos nulos, vacíos, inválidos.
        Datos de Salida idénticos a datos de Entrada.
        Cálculo del Promedio.
        Leyenda del Diploma.
        Mensaje de Diploma con Honores.

     */





}
