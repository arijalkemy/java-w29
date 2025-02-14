package meli.ejercicio.service;

import meli.ejercicio.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {
    TestCaseDto getTestCaseById(Long id);
    TestCaseDto createTestCase(TestCaseDto testCaseDto);
    TestCaseDto updateTestCase(TestCaseDto testCaseDto, Long id);
    void deleteTestCase(Long id);
    List<TestCaseDto> getAllTestCases();
    List<TestCaseDto> getTestCasesByFecha(LocalDate fecha);
}
