package com.mdaneri;

import com.mdaneri.impl.Deposit;
import com.mdaneri.impl.Transfer;

public class Executive {

    private Deposit deposit;
    private Transfer transfer;

    public Executive(Deposit deposit, Transfer transfer) {
        this.deposit = deposit;
        this.transfer = transfer;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public Transfer getTransfer() {
        return transfer;
    }
}
