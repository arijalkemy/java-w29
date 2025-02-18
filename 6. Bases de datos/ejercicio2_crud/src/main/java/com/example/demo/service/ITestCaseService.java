package com.example.demo.service;

import com.example.demo.dto.response.TestCaseResDTO;
import com.example.demo.dto.request.TestCaseReqDTO;
import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    void createTestCase(TestCaseReqDTO testCaseReqDTO);
    void deleteTestCase(Long id);
    void updateTestCase(Long id, TestCaseReqDTO testCaseReqDTO);
    List<TestCaseResDTO> getTestCases(LocalDate lastUpdate);
    TestCaseResDTO getTestCaseById(Long id);
}
