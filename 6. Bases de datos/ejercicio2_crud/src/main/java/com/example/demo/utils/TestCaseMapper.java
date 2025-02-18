package com.example.demo.utils;
import com.example.demo.dto.request.TestCaseReqDTO;
import com.example.demo.dto.response.TestCaseResDTO;
import com.example.demo.model.TestCase;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TestCaseMapper {
    private final ModelMapper mapper;

    public TestCaseMapper() {
        this.mapper = new ModelMapper();
    }

    public TestCaseResDTO resToDTO(TestCase testCase) {
        return mapper.map(testCase, TestCaseResDTO.class);
    }

    public TestCase reqToEntity(TestCaseReqDTO testCaseReqDTO) {
        return mapper.map(testCaseReqDTO, TestCase.class);
    }
}

