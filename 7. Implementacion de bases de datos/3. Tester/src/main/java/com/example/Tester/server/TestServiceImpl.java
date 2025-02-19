package com.example.Tester.server;

import com.example.Tester.dto.request.TestDtoRequest;
import com.example.Tester.dto.response.TestDtoResponse;
import com.example.Tester.entity.Tester;
import com.example.Tester.exception.BadRequestException;
import com.example.Tester.exception.NotFoundException;
import com.example.Tester.repository.ITesterRepository;
import com.example.Tester.util.TesterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements ITesterService {

    private final ITesterRepository repository;

    @Override
    public TestDtoResponse addNewTest(TestDtoRequest request) {
        Tester tester = repository.save(TesterMapper.INSTANCE.testerDtoToTester(request));
        return TesterMapper.INSTANCE.testerToTesterDto(tester);
    }

    @Override
    public List<TestDtoResponse> getAllTest(String date) {
        if (date == null) {
            List<Tester> testerList = repository.findAll();
            return testerList.
                    stream()
                    .map(TesterMapper.INSTANCE::testerToTesterDto)
                    .toList();
        }
        return getAllTestByDate(date);
    }

    private List<TestDtoResponse> getAllTestByDate(String date) {
        if (date.isEmpty()) {
            throw new BadRequestException("Invalid date");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        return repository.findByLastUpdateAfter(parsedDate).stream()
                .map(TesterMapper.INSTANCE::testerToTesterDto)
                .toList();
    }

    @Override
    public TestDtoResponse getTestById(Long id) {
        Optional<Tester> tester = repository.findById(id);
        if (tester.isEmpty()) {
            throw new NotFoundException("Test not found");
        }
        return TesterMapper.INSTANCE.testerToTesterDto(tester.get());
    }

    @Override
    public TestDtoResponse updateTestById(Long id, TestDtoRequest newTest) {
        Optional<Tester> tester = repository.findById(id);
        if (tester.isEmpty()) {
            throw new NotFoundException("Test not found");
        }
        Tester updated = TesterMapper.INSTANCE.testerDtoToTester(newTest);
        updated.setIdCase(id);
        return TesterMapper.INSTANCE.testerToTesterDto(repository.save(updated));
    }

    @Override
    public TestDtoResponse deleteTestById(Long id) {
        Optional<Tester> tester = repository.findById(id);
        if (tester.isEmpty()) {
            throw new NotFoundException("Test not found");
        }
        repository.delete(tester.get());
        return TesterMapper.INSTANCE.testerToTesterDto(tester.get());
    }
}
