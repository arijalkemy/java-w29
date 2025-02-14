package jpa.qa_testers.service;

import jpa.qa_testers.entity.response.AllTestsCasesDTO;
import jpa.qa_testers.entity.response.ResponseWrapperDTO;
import jpa.qa_testers.entity.resquest.TestCaseRequestDTO;

public interface ITestCaseService {
    ResponseWrapperDTO createTestCase(TestCaseRequestDTO testCaseRequestDTO);
    ResponseWrapperDTO updateTestCase(Long caseId, TestCaseRequestDTO testCaseRequestDTO);
    ResponseWrapperDTO deleteTestCase(Long caseId);
    TestCaseRequestDTO getTestCase(Long caseId);
    AllTestsCasesDTO getAllTestCases();
    AllTestsCasesDTO filterByDate(String date);
    AllTestsCasesDTO filterIsTested();
}