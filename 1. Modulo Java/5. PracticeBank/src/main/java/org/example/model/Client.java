package org.example.model;

/**
 * Represents a client of the bank
 */
public class Client {

    /**
     * Attributes
     */
    private double balance;

    /**
     * Constructor
     */
    public Client(double balance) {
        this.balance = balance;
    }

    /**
     * Getters and setters
     */

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
