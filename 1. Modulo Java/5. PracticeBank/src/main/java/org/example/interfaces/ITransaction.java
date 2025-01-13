package org.example.interfaces;

public interface ITransaction {

    /**
     * Method that indicates that the transaction was successful
     */
    void transactionOk(String typeTransaction);

    /**
     * Method that indicates that the transaction was not successful
     * @param error to print
     */
    void transactionNotOk(String typeTransaction, String error);
}
