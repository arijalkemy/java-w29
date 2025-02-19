package com.bootcamp.crudjpa.service;

import com.bootcamp.crudjpa.dto.TestCaseDto;
import com.bootcamp.crudjpa.model.TestCase;
import com.bootcamp.crudjpa.repository.ITestCaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestCaseServiceTest {

    @Mock
    private ITestCaseRepository repository;

    @InjectMocks
    private TestCaseServiceImpl service;

    @Test
    void createTestCase() {
        // Arrange
        TestCase expected = new TestCase();
        expected.setIdCase(1L);

        TestCaseDto param = new TestCaseDto();
        when(repository.save(any(TestCase.class))).thenAnswer(i -> {
            TestCase testCase = (TestCase) i.getArguments()[0];
            testCase.setIdCase(1L);
            return testCase;
        });

        // Act
        TestCase actual = service.createTestCase(param);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void readAllTestCases() {
        // Arrange
        Integer expectedLength = 1;
        when(repository.findAll()).thenReturn(new ArrayList<TestCase>() {{
            add(new TestCase());
        }});
        //Act
        Integer actualLength = service.readAllTestCases(null).size();
        //Assert
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void readTestCase() {
        Long param = 1L;
        TestCase expected = new TestCase();
        expected.setIdCase(1L);
        when(repository.findById(param)).thenReturn(java.util.Optional.of(new TestCase() {{
            setIdCase(1L);
        }}));
        TestCase actual = service.readTestCase(param);
        assertEquals(expected, actual);
    }

    @Test
    void updateTestCase() {
        TestCase expected = new TestCase();
        expected.setIdCase(1L);
        expected.setPassed(false);
        Long paramId = 1L;
        TestCaseDto paramDto = new TestCaseDto();
        paramDto.setPassed(false);
        when(repository.existsById(paramId)).thenReturn(true);
        when(repository.save(any(TestCase.class))).thenAnswer(i -> i.getArguments()[0]);
        TestCase actual = service.updateTestCase(paramId, paramDto);
        assertEquals(expected, actual);
    }

    @Test
    void deleteTestCase() {
        Long param = 1L;
        when(repository.existsById(param)).thenReturn(true);
        service.deleteTestCase(param);
        verify(repository).deleteById(param);
    }
}