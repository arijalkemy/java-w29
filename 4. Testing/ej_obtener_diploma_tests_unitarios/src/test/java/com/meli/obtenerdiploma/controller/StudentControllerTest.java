package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private IStudentService service;

    @InjectMocks
    private StudentController controller;

    @Test
    @DisplayName("Register student")
    void registerStudent() {
        StudentDTO studentDTO = new StudentDTO();
        controller.registerStudent(studentDTO);
        verify(service).create(studentDTO);
    }

    @Test
    @DisplayName("Get student by id")
    void getStudentById() {
        controller.getStudent(1L);
        verify(service).read(1L);
    }

    @Test
    @DisplayName("Modify student")
    void modifyStudent() {
        StudentDTO studentDTO = new StudentDTO();
        controller.modifyStudent(studentDTO);
        verify(service).update(studentDTO);
    }

    @Test
    @DisplayName("Remove student")
    void removeStudent() {
        controller.removeStudent(1L);
        verify(service).delete(1L);
    }

    @Test
    @DisplayName("List all students")
    void listAllStudents() {
        controller.listStudents();
        verify(service).getAll();
    }
}