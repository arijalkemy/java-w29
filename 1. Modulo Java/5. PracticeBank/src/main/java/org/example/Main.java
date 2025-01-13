package org.example;

import org.example.model.Basic;
import org.example.model.Collaborators;
import org.example.model.Executives;

public class Main {
    public static void main(String[] args) {
        Executives executive = new Executives(50000);
        Basic basic = new Basic(50000);
        Collaborators collaborator = new Collaborators(50000);

        executive.makeDeposit(100000);
        executive.makeTransfer("AS1245", 100);

        basic.makeCheckBalance();
        basic.makePayment("Agua", 200);
        basic.makeCashWithdrawal(10000);
        basic.makeCheckBalance();

        collaborator.makeCheckBalance();
        collaborator.makeCashWithdrawal(20000);
        collaborator.makeCheckBalance();
    }
}