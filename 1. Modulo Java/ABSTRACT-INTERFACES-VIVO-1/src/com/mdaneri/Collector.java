package com.mdaneri;

import com.mdaneri.impl.Balance;
import com.mdaneri.impl.CashOut;

public class Collector {

    private CashOut cashOut;
    private Balance balance;

    public Collector(CashOut cashOut, Balance balance) {
        this.cashOut = cashOut;
        this.balance = balance;
    }

    public CashOut getCashOut() {
        return cashOut;
    }

    public Balance getBalance() {
        return balance;
    }
}
