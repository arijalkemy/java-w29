package com.mdaneri.impl;

import com.mdaneri.interfaces.Transaction;

public class Transfer implements Transaction {

    @Override
    public void ok() {
        System.out.println("Transferencia ok");
    }

    @Override
    public void noOk() {
        System.out.println("Transferencia errónea");
    }

}
