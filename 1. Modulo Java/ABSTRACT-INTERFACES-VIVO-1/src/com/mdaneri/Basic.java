package com.mdaneri;

import com.mdaneri.impl.Balance;
import com.mdaneri.impl.CashOut;
import com.mdaneri.impl.ServicesPayment;

public class Basic {

    private Balance balance;
    private CashOut cashOut;
    private ServicesPayment servicesPayment;

    public Basic(Balance balance, CashOut cashOut, ServicesPayment servicesPayment) {
        this.balance = balance;
        this.cashOut = cashOut;
        this.servicesPayment = servicesPayment;
    }

    public Balance getBalance() {
        return balance;
    }

    public CashOut getCashOut() {
        return cashOut;
    }

    public ServicesPayment getServicesPayment() {
        return servicesPayment;
    }
}
