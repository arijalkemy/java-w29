package com.example.testers.service;

import com.example.testers.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface TestCaseService {
    List<TestCase> getTestCases(LocalDate lastUpdate);

    List<TestCase> getTestCases();

    void saveTestCase(TestCase testCase);

    TestCase findTestCase(Long id);

    void updateTestCase(Long id, TestCase testCase);

    void deleteTestCase(Long id);
}
