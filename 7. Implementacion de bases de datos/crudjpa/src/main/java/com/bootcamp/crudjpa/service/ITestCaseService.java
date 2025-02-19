package com.bootcamp.crudjpa.service;

import com.bootcamp.crudjpa.dto.TestCaseDto;
import com.bootcamp.crudjpa.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    public TestCase createTestCase(TestCaseDto testCaseDto);
    public List<TestCase> readAllTestCases(LocalDate filter);
    public TestCase readTestCase(Long id);
    public TestCase updateTestCase(Long id, TestCaseDto testCaseDto);
    public Boolean deleteTestCase(Long id);
}
