package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // agregamos la clase

public class StudentControllerTest {
    @Mock
    IStudentService service;
    @InjectMocks
    StudentController controller;

    @Test
    @DisplayName("Registrar un nuevo estudiante - Éxito")
    void registerStudentOkTest() {
        // Arrange
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, new ArrayList<>());
        // Act
        ResponseEntity<?> response = controller.registerStudent(student);
        // Assert
        assertEquals(200, response.getStatusCodeValue()); // Verificar estado 200 OK
        verify(service).create(student); // Verificar que se llamó al método create en el servicio
    }

    @Test
    @DisplayName("Obtener estudiante por ID - Éxito")
    void getStudentOkTest() {
        // Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(studentId, "Juan", null, null, null);
        when(service.read(studentId)).thenReturn(student);
        // Act
        StudentDTO result = controller.getStudent(studentId);
        // Assert
        assertEquals(student, result); // Verificar que el estudiante retornado es el correcto
        verify(service).read(studentId); // Verificar que se llamó al método read en el servicio
    }

    @Test
    @DisplayName("modifyStudent")
    void modifyStudentOkTest(){
        //arrenge
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, null);
        //act
        ResponseEntity<?> response = controller.modifyStudent(student);
        //assert
        assertEquals(200, response.getStatusCodeValue());
        verify(service).update(student);
    }

    @Test
    @DisplayName("removeStudent")
    void removeStudentOkTest(){
        //arrenge
        StudentDTO student = new StudentDTO(1L, "Juan", null, null, null);
        //act
        ResponseEntity<?> result = controller.removeStudent(student.getId());
        //assert
        assertEquals(200, result.getStatusCodeValue());
        verify(service).delete(student.getId());
    }

    @Test
    @DisplayName("listStudents")
    void listStudentsOkTest(){
        //arrengue
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO(1L,"Taiel","Cleiman",9.0,null));
        students.add(new StudentDTO(2L,"pepe","argento",9.0,null));
        when(service.getAll()).thenReturn(students);
        //act
        Set<StudentDTO> result = controller.listStudents();
        //assert
        assertEquals(students,result);
        verify(service).getAll();
    }

}

