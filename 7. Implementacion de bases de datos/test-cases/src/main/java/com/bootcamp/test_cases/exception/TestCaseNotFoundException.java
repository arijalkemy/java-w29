package com.bootcamp.test_cases.exception;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(String message) {
        super(message);
    }
}
