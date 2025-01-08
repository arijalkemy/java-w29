package com.mdaneri.impl;

import com.mdaneri.interfaces.Transaction;

public class ServicesPayment implements Transaction {

    @Override
    public void ok() {
        System.out.println("Pago de servicio ok");
    }

    @Override
    public void noOk() {
        System.out.println("Pago de servicio erróneo");
    }
}
