package org.example.interfaces;

public interface ICheckBalance extends ITransaction {

    String CHECK_TAG = "Consulta de saldo";
    /**
     * Check the customer's account balance
     */
    void makeCheckBalance();
}
