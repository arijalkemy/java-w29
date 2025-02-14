package com.testers.apitester.service;

import com.testers.apitester.model.TestCase;

import java.util.List;

public interface ITestCaseService {
    public void saveTestCase(TestCase testCase);
    public List<TestCase> getTestCase();
    public TestCase findTestById(Long id);
    public void deleteTest(Long id);
}
