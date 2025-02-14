package com.example.qa_tester.service;

import com.example.qa_tester.dto.RequestTestCaseDto;
import com.example.qa_tester.dto.ResponseTestCaseDto;

import java.util.List;

public interface ITestCaseService {
    List<ResponseTestCaseDto> searchAll();
    ResponseTestCaseDto searchById(Long id);
    void create(RequestTestCaseDto request);
    void updateById(Long id, RequestTestCaseDto request);
    void deleteById(Long id);
}
