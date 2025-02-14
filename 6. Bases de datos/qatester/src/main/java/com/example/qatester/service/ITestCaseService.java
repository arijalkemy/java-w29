package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.response.ApiResponseDto;
import com.example.qatester.entity.TestCase;

import java.util.List;

public interface ITestCaseService {
    //Crear, recuperar, actualizar y eliminar casos de prueba.

    ApiResponseDto createTestCase(TestCaseDto testCaseDto);
    TestCaseDto getTestCaseById(Long id);
    List<TestCaseDto> getAllTestCase();
    ApiResponseDto updateTestCase(Long id_modificar, TestCaseDto testCase_modif);
    ApiResponseDto deleteTestCaseById(Long id);
}
