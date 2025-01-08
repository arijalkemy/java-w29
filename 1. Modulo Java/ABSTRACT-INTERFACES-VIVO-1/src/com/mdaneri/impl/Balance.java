package com.mdaneri.impl;

import com.mdaneri.interfaces.Transaction;

public class Balance implements Transaction {

    @Override
    public void ok() {
        System.out.println("Consulta de saldo ok");
    }

    @Override
    public void noOk() {
        System.out.println("Consulta de saldo erróneo");
    }
}
