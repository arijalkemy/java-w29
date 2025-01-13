package org.example.model;

import org.example.interfaces.IDeposit;
import org.example.interfaces.ITransfer;

public class Executives extends Client implements IDeposit, ITransfer {

    /**
     * Constructor
     *
     * @param balance client balance
     */
    public Executives(double balance) {
        super(balance);
    }

    @Override
    public void makeDeposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            transactionOk(DEPOSIT_TAG);
        }
        else
            transactionNotOk(DEPOSIT_TAG, "Ingrese un monto mayor a 0");
    }

    @Override
    public void makeTransfer(String account, double amount) {
        if(!account.isEmpty()) {
            if (amount > 0) {
                setBalance(getBalance() - amount);
                transactionOk(TRANSFER_TAG);
            } else
                transactionNotOk(TRANSFER_TAG, "Ingrese un monto válido");
        } else
            transactionNotOk(TRANSFER_TAG, "Ingrese un número de cuenta válido");

    }

    @Override
    public void transactionOk(String typeTransaction) {
        System.out.println(typeTransaction + " realizado exitosamente");
    }

    @Override
    public void transactionNotOk(String typeTransaction, String error) {
        System.out.println(typeTransaction + " no realizado, error: " + error);
    }
}
