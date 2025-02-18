package com.meli.qatesters.service;

import com.meli.qatesters.model.TestCase;

import java.util.List;

public interface ITestCaseService {
    List<TestCase> getTestCases();
    TestCase findTestCase(Long id);
    void saveTestCase(TestCase testCase);
    TestCase updateTestCase(TestCase testCase, Long id);
    void deleteTestCase(Long id);
    List<TestCase> getTestCasesLastUpdate(String lastUpdateTime);
}
