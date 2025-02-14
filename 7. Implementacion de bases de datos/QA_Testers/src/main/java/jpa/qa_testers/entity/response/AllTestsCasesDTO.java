package jpa.qa_testers.entity.response;

import jpa.qa_testers.entity.resquest.TestCaseRequestDTO;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AllTestsCasesDTO {
    List<TestCaseRequestDTO> testCases;
}