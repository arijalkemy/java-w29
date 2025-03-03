package org.meli.qatesters.service;

import org.meli.qatesters.dto.request.TestCaseDTO;
import org.meli.qatesters.entity.TestCase;

import java.util.List;

public interface ITestCaseService {
    TestCase createTestCase(TestCaseDTO testCaseDto);
    TestCase getTestCaseById(Long id);
    List<TestCase> getAllTestCases();
    TestCase updateTestCase(Long id, TestCaseDTO testCaseDto);
    void deleteTestCase(Long id);
    List<TestCase> getTestCasesByDate(String date);
}
