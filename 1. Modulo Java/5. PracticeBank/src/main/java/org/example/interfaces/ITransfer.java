package org.example.interfaces;

public interface ITransfer extends ITransaction {
    String TRANSFER_TAG = "Transferencia";

    /**
     * Make a transfer to another account
     * @param account to transfer
     * @param amount to transfer
     */
    void makeTransfer(String account, double amount);
}