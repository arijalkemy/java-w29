package com.testcase.apitestcase.service;

import com.testcase.apitestcase.model.TestCase;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITestCaseService {
    TestCase saveTestCase(TestCase testCase);
    List<TestCase> getAllTestCase();
    Optional<TestCase> findTestCase(Long id);
    void deleteTestCase(Long id);
    List<TestCase> findTestByDate(LocalDate date);
}
