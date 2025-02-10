package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.Datos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    IStudentDAO dao;
    @Mock
    IStudentRepository repository;
    @InjectMocks
    StudentService service;

    @Test
    void create() {
        //Arrgane
        StudentDTO student= Datos.unEstudiante();
        //ACT
        service.create(student);
        //Assert
        verify(dao).save(student);
    }

    @Test
    void read() {
        //Arrgane
        StudentDTO expected= Datos.unEstudiante();
        when(dao.findById(expected.getId())).thenReturn(expected);
        Long id= expected.getId();
        //ACT


        //Assert
        verify(dao).save(student);


    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}