package com.bootcampw29.qa_testers.service;

import com.bootcampw29.qa_testers.dto.request.TestCaseRequestDTO;
import com.bootcampw29.qa_testers.dto.response.TestCaseCreatedDTO;
import com.bootcampw29.qa_testers.dto.response.TestCaseResponseDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TestCaseService {
    TestCaseCreatedDTO createTestCase(TestCaseRequestDTO testCaseRequest);
    TestCaseResponseDTO modifyTestCase(Long id, TestCaseRequestDTO testCaseRequest);
    List<TestCaseResponseDTO> searchAllTestCases(Optional<LocalDate> lastUpdate);
    TestCaseResponseDTO searchTestCaseById(Long id);
    void deleteTestCase(Long id);
}
