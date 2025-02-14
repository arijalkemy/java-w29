package exercise.qa_testers.service;


import exercise.qa_testers.dto.request.TestCaseRequestDto;
import exercise.qa_testers.model.TestCase;

import java.time.LocalDate;
import java.util.List;

public interface ITestCaseService {
    List<TestCase> getAll(LocalDate lastUpdate);
    TestCase getById(Long id);
    TestCase update(TestCaseRequestDto testCaseDto, Long id);
    void delete(Long id);
    void save(TestCaseRequestDto testCaseDto);
}
