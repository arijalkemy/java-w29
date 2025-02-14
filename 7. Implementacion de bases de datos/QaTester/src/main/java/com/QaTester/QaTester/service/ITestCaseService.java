package com.QaTester.QaTester.service;

import com.QaTester.QaTester.dto.TestCaseDto;

import java.time.LocalDate;
import java.util.List;


public interface ITestCaseService {
    List<TestCaseDto> getAll();
    TestCaseDto getById(Long id);
    TestCaseDto addTestCase(TestCaseDto dto);
    TestCaseDto update(Long id,TestCaseDto dto);
    TestCaseDto delete(Long id);
    List<TestCaseDto> getByDate(String date);

    List<TestCaseDto> findByLastUpdateAfter(LocalDate lastUpdate);
}
