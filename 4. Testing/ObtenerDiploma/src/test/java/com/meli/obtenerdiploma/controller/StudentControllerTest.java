package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    @DisplayName("Happy path registerStudent")
    void regiterStudentTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);
        var actual = controller.registerStudent(student);

        assertEquals(ResponseEntity.ok(null), actual);

    }

    @Test
    @DisplayName("Happy path modify")
    void modifyStudentTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);
        var actual = controller.modifyStudent(student);

        assertEquals(ResponseEntity.ok(null), actual);

    }

    @Test
    @DisplayName("Happy path remove")
    void removeStudentTest(){
        var actual = controller.removeStudent(1L);

        assertEquals(ResponseEntity.ok(null), actual);

    }

    @Test
    @DisplayName("Happy path get")
    void getStudentTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        when(service.read(1L)).thenReturn(student);
        var actual = controller.getStudent(1L);

        assertEquals(student, actual);

    }

    @Test
    @DisplayName("Happy path list")
    void listStudentTest(){
        List<SubjectDTO> subjetc = List.of(new SubjectDTO("Matematica",7.8));
        StudentDTO student = new StudentDTO(1L,"Pepe","hola",7.8,subjetc);

        when(service.getAll()).thenReturn(Set.of(student));

        var actual = controller.listStudents();

        assertEquals(Set.of(student), actual);
    }
}
