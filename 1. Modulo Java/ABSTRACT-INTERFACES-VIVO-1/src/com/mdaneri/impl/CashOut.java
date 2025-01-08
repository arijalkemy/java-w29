package com.mdaneri.impl;

import com.mdaneri.interfaces.Transaction;

public class CashOut implements Transaction {

    @Override
    public void ok() {
        System.out.println("Retiro de efectivo ok");
    }

    @Override
    public void noOk() {
        System.out.println("Retiro de efectivo erróneo");
    }

}
