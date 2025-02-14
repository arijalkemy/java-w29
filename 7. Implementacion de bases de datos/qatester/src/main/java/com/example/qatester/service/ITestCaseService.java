package com.example.qatester.service;

import com.example.qatester.dto.TestCaseDto;
import com.example.qatester.dto.out.MessageDto;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

public interface ITestCaseService {
    MessageDto addTestCase(@Valid TestCaseDto testCaseDto);

    List<TestCaseDto> searchTestCase();

    TestCaseDto searchTestCaseById(@Positive Long id) throws Exception;

    TestCaseDto modifyById(@Positive Long id, @Valid TestCaseDto testCaseDto) throws Exception;

    MessageDto deleteById(@Positive Long id);

    List<TestCaseDto> filterByDate(String lastUpdate);
}
