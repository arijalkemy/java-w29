package com.example.qa_testers.service;

import com.example.qa_testers.entity.request.TestCaseRequestDTO;
import com.example.qa_testers.entity.response.AllTestsCasesDTO;
import com.example.qa_testers.entity.response.ResponseWrapperDTO;

public interface ITestCaseService {
    ResponseWrapperDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO);
    ResponseWrapperDTO updateTestCase(Long caseId, TestCaseRequestDTO testCaseRequestDTO);
    ResponseWrapperDTO deleteTestCase(Long caseId);
    TestCaseRequestDTO getTestCase(Long caseId);
    AllTestsCasesDTO getAllTestCases();
    AllTestsCasesDTO filterByDate(String date);
    AllTestsCasesDTO filterIsTested();
}
