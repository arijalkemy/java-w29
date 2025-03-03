package org.meli.qatesters.exception;

public class TestCaseNotFoundException extends RuntimeException {
    public TestCaseNotFoundException(Long testId) {
        super("Test case not found with id " + testId);
    }
}
