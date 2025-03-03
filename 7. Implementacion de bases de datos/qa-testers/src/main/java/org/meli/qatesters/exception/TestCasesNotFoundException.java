package org.meli.qatesters.exception;

public class TestCasesNotFoundException extends RuntimeException {
    public TestCasesNotFoundException() {
        super("Test cases not found with the specified filters");
    }
}
