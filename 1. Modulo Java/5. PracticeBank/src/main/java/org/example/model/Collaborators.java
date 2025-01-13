package org.example.model;

import org.example.interfaces.ICheckBalance;
import org.example.interfaces.IWithdraw;

public class Collaborators extends Client implements IWithdraw, ICheckBalance {
    /**
     * Constructor
     *
     * @param balance client balance
     */
    public Collaborators(double balance) {
        super(balance);
    }

    @Override
    public void makeCheckBalance() {
        if (getBalance() > 0) {
            System.out.println("El saldo acctual es: " + getBalance());
        }
        else
            transactionNotOk(CHECK_TAG, "Monto inválido");
    }

    @Override
    public void makeCashWithdrawal(double amount) {
        if (amount > 0) {
            if (getBalance() - amount > 0) {
                setBalance(getBalance() - amount);
                transactionOk(WITHDRAW_TAG);
            } else
                transactionNotOk(WITHDRAW_TAG, "Saldo insuficiente");
        } else
            transactionNotOk(WITHDRAW_TAG, "Monto no válido");
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
