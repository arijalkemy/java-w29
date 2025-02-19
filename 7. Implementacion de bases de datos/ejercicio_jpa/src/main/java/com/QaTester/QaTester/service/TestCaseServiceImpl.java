package com.QaTester.QaTester.service;

import com.QaTester.QaTester.dto.TestCaseDto;
import com.QaTester.QaTester.model.TestCase;
import com.QaTester.QaTester.repository.ITestCaseRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.boot.Banner;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final ITestCaseRepository repository;
    private final ModelMapper mp = new ModelMapper();

    public TestCaseServiceImpl(ITestCaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TestCaseDto> getAll() {
        List<TestCase> cases = repository.findAll();
        Type listType = new TypeToken<List<TestCaseDto>>() {}.getType();
        return mp.map(cases,listType);
    }

    @Override
    public TestCaseDto getById(Long id) {
        Optional<TestCase> exist = repository.findById(id);
        if (exist.isEmpty()){
           throw new RuntimeException("No existe el Case");
        }
        return mp.map(exist.get(),TestCaseDto.class);
    }

    @Override
    public TestCaseDto addTestCase(TestCaseDto dto) {
        repository.save(mp.map(dto, TestCase.class));
        return dto;
    }

    @Override
    public TestCaseDto update(Long id, TestCaseDto dto) {
        Optional<TestCase> exist = repository.findById(id);
        if (exist.isEmpty()){
            throw new RuntimeException("No existe el Case");
        }
        exist.get().setDescription(dto.getDescription());
        exist.get().setTested(dto.getTested());
        exist.get().setLastUpdate(dto.getLastUpdate());
        exist.get().setNumberOfTries(dto.getNumberOfTries());
        exist.get().setPassed(dto.getPassed());
        repository.save(exist.get());
        return dto;
    }

    @Override
    public TestCaseDto delete(Long id) {
        return null;
    }

    @Override
    public List<TestCaseDto> getByDate(String date) {
        return List.of();
    }
}
