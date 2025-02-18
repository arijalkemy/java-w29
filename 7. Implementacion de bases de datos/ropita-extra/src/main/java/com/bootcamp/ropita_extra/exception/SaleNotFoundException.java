package com.bootcamp.ropita_extra.exception;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException() {
        super("Sale not found :(");
    }
}
