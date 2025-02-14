package com.example.qa_testers.entity.response;

import com.example.qa_testers.entity.request.TestCaseRequestDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AllTestsCasesDTO {
    List<TestCaseRequestDTO> testCases;
}
