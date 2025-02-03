package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import java.util.List;
import java.util.Set;


import static org.mockito.BDDMockito.given;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc

public class StudentControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentDAO studentDAO;

    @MockBean
    private StudentRepository studentRepository;

    SubjectDTO db = new SubjectDTO("BaseDeDatos", 10.0);
    SubjectDTO tdp = new SubjectDTO("TallerDeDesarrollDeProyectos", 8.0);

    StudentDTO student = StudentDTO.builder()
            .id(1L)
            .studentName("Christian")
            .subjects(List.of(db, tdp))
            .build();

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Get existing student by id happy way")
    void testGetStudentById() throws Exception {
        //uso given para simular el comportamiento de findId
        given(studentDAO.findById(1L)).willReturn(student);

        //pruebo el endpoint get con un id especifico, hago la solicitud
        mockMvc.perform(get("/student/getStudent/{id}", student.getId()))
                // ya ahora que espero que me devuelva el get
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(student.getId()))
                .andExpect(jsonPath("$.studentName").value(student.getStudentName()));
    }

    //probar la excepcion
    @Test
    @DisplayName("Test exception not found exception")
    void testGetStudentByNotFound() throws Exception {
        //le estoy diciendo que
        given(studentDAO.findById(student.getId())).willThrow(StudentNotFoundException.class);

        mockMvc.perform(get("/student/getStudent/{id}", student.getId()))
                .andExpect(status().isNotFound());
    }

/*Analizo los posibles casos del registro de usuariso*/

    /*Creo en el registro un usuario happy way*/
    @Test
    @DisplayName("Register student successfully")
    void testRegisterStudentSuccessfully() throws Exception {
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(student)))
                .andExpect(status().isCreated());
    }

    /*Caso de un post donde el body venga totalmente vacio*/
    @Test
    @DisplayName("Register student with no body")
    void testRegisterNoStudent() throws Exception {
        //no le paso ningun tipo de contenido para que salga bad request
        mockMvc.perform(post("/student/registerStudent"))
                .andExpect(status().isBadRequest());
    }

    /*Caso en el que en post el nombre sea invalido pongo solo minuscula y la validacion no pasara*/
    @Test
    @DisplayName("Register student with invalida formation name")
    void testRegisterInvalidName() throws Exception {
        StudentDTO invalidStudentName  = StudentDTO.builder()
                .studentName("chris")
                .subjects(List.of(db, tdp))
                .build();

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                //analizar este metodo
                .content(mapper.writeValueAsString(invalidStudentName )))
                .andExpect(status().isBadRequest());

    }

    /*Caso en el que no pasan las validaciones de subjects cuando se lo carga al student*/
    @Test
    @DisplayName("Register student with invalid subjects")
    void testRegisterInvalidSubject() throws Exception {
        StudentDTO invalidStudentSubject = StudentDTO.builder().studentName("Chris").subjects(List.of()).build();

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidStudentSubject)))
                .andExpect(status().isBadRequest());
    }

/*Analizo los posibles casos de modify student*/

    /*Modifico un estudiante satisfactoriamente*/

    @Test
    @DisplayName("Modify student succesfully")
    void testModifyStudentSuccesfully() throws Exception {
        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(student)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Modify student with invalida name")
    void testModifyStudentWithInvalidName () throws Exception {
        StudentDTO studentInvalidName = StudentDTO.builder()
                .studentName("chris")
                .subjects(List.of(db, tdp))
                .build();
        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(studentInvalidName)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Modify student with invalid subject")
    void testModifyStudentWithInvalidSubject() throws Exception {
        StudentDTO studentWithInvalidSubject = StudentDTO.builder()
                .studentName("Chris")
                .subjects(List.of())
                .build();
        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(studentWithInvalidSubject)))
                .andExpect(status().isBadRequest());
    }

    /*Realizamos los tests para eliminar un estudiante*/
    @Test
    @DisplayName("Remove a student succesfully")
    void testRemoveStudentSuccesfully() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 1L))
                .andExpect(status().isOk());
    }

    /*Preueba que se maneja la excepcion correctamente si no se encuentra el usuario*/
    @Test
    @DisplayName("Remove non existing student")
    void testRemoveStudentNotFound() throws Exception {
        Long studentId = 1L;

        // Configura mock para lanzar excepción cuando se intente eliminar con este ID
        doThrow(StudentNotFoundException.class).when(studentDAO).delete(studentId);

        // Realiza la solicitud GET al endpoint de eliminación
        mockMvc.perform(get("/student/removeStudent/{id}", studentId))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("List students")
    void testListStudents() throws Exception {
        given(studentRepository.findAll()).willReturn(Set.of(student));
        mockMvc.perform(get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(student.getId()))
                .andExpect(jsonPath("$[0].studentName").value(student.getStudentName()))
                .andExpect(jsonPath("$[0].averageScore").value(student.getAverageScore()));
    }






















}
