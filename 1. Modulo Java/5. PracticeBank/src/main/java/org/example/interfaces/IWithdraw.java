package org.example.interfaces;

public interface IWithdraw extends ITransaction {

    String WITHDRAW_TAG = "Retiro de efectivo";
    /**
     * Makes a cash withdrawal from an account
     * @param amount to withdraw
     */
    void makeCashWithdrawal(double amount);
}
