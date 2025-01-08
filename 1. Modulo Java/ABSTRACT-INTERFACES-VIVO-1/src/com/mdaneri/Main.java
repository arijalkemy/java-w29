package com.mdaneri;

import com.mdaneri.impl.*;

public class Main {
    public static void main(String[] args) {

        Balance balance = new Balance();
        CashOut cashOut = new CashOut();
        Deposit deposit = new Deposit();
        ServicesPayment servicesPayment = new ServicesPayment();
        Transfer transfer = new Transfer();

        Executive executive = new Executive(deposit, transfer);
        Basic basic = new Basic(balance, cashOut, servicesPayment);

        executive.getTransfer().ok();
        executive.getTransfer().noOk();

        basic.getServicesPayment().noOk();

    }
}