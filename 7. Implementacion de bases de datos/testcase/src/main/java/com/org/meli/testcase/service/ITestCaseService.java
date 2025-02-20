package com.org.meli.testcase.service;

import com.org.meli.testcase.dto.TestCaseDto;
import com.org.meli.testcase.entity.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public TestCaseDto saveTestCase(TestCaseDto testCaseDto);
    public List<TestCaseDto> findAllTestCases();
    public TestCaseDto findTestCaseById(Long id);
    public TestCaseDto updateTestCase(Long id, TestCaseDto testCaseDto);
    public TestCaseDto deleteTestCase(Long id);
    public List<TestCase> findTestCasesAfterDate(LocalDate date);
}
