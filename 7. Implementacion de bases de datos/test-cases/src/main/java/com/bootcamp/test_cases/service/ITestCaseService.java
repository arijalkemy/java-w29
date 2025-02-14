package com.bootcamp.test_cases.service;

import com.bootcamp.test_cases.dto.TestCaseDto;

import java.util.List;

public interface ITestCaseService {
    TestCaseDto createTestCase(TestCaseDto testCaseDto);

    List<TestCaseDto> getAllTestCases(String date);

    TestCaseDto getCaseById(Long id);

    TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto);

    void deleteTestCaseById(Long id);
}
