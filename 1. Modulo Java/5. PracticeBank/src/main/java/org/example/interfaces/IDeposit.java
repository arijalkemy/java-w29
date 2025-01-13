package org.example.interfaces;

public interface IDeposit extends ITransaction {

    String DEPOSIT_TAG = "Deposito";
    /**
     * Make a deposit to an account
     * @param amount to deposit
     */
    void makeDeposit(double amount);
}
