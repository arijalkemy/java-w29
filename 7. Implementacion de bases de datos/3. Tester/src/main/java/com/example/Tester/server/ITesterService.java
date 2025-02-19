package com.example.Tester.server;

import com.example.Tester.dto.request.TestDtoRequest;
import com.example.Tester.dto.response.TestDtoResponse;

import java.util.List;

public interface ITesterService {
    TestDtoResponse addNewTest(TestDtoRequest request);
    List<TestDtoResponse> getAllTest(String date);
    TestDtoResponse getTestById(Long id);
    TestDtoResponse updateTestById(Long id, TestDtoRequest newTest);
    TestDtoResponse deleteTestById(Long id);
}
