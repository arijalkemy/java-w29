package org.melibootcamp.qatester.service;

import org.melibootcamp.qatester.dto.MessajeDto;
import org.melibootcamp.qatester.dto.TestDto;

import java.util.List;

public interface ITestService {
    MessajeDto createTestCase(TestDto testCaseDTO);
    MessajeDto updateTestCase(TestDto testCaseDTO);
    MessajeDto deleteTestCase(Long id);
    TestDto getTestCase(Long id);
    List<TestDto> getAllTestCases();
    List<TestDto> getNotPassedTest();

}
