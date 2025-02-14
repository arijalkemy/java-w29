package com.meli.qa.service;

import com.meli.qa.dto.request.AddTestCaseRequestDto;
import com.meli.qa.dto.request.TestCaseDto;

import java.util.List;

public interface ITestCaseService {
    TestCaseDto save(AddTestCaseRequestDto testCaseDto);
    List<TestCaseDto> findAll();
    TestCaseDto findById(Long id);
    TestCaseDto update(Long id, AddTestCaseRequestDto testCaseDto);
    void delete(Long id);
}
