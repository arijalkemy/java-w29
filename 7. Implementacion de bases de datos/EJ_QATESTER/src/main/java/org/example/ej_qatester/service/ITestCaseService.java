package org.example.ej_qatester.service;

import org.example.ej_qatester.dto.TestCaseDto;
import org.example.ej_qatester.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    List<TestCaseDto> getAllTestCase(LocalDate lastUpdate);


    TestCaseDto addTestCase(TestCaseDto testCaseDto);

    TestCaseDto findTestCaseById(Long testCaseId);

    TestCaseDto updateTestCase(Long testCaseId, TestCaseDto te);

    void deleteTest(Long id);
}
