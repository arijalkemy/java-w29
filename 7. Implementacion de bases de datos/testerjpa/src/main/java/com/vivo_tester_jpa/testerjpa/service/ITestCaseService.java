package com.vivo_tester_jpa.testerjpa.service;

import com.vivo_tester_jpa.testerjpa.dto.MessageDto;
import com.vivo_tester_jpa.testerjpa.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {

    public MessageDto saveTestCase(TestCase tc);

    public List<TestCase> getAllTestCase();

    List<TestCase> getTestCasesByLastUpdateAfter(LocalDate date);

    public TestCase getTestCaseById(Long id);

    public MessageDto deleteTestCase(Long id);
}
