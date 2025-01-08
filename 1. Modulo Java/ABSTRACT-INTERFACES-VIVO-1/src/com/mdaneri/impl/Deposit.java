package com.mdaneri.impl;

import com.mdaneri.interfaces.Transaction;

public class Deposit implements Transaction {

    @Override
    public void ok() {
        System.out.println("Depósito ok");
    }

    @Override
    public void noOk() {
        System.out.println("Depósito erroneo");
    }
}
