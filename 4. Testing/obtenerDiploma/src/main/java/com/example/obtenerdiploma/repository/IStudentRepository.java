package com.example.obtenerdiploma.service;


import com.example.obtenerdiploma.model.StudentDTO;

import java.util.Set;

public interface IStudentRepository {

    Set<StudentDTO> findAll();

}