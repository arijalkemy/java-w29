package org.example;

public class Perishable extends Product {

    // Attributes
    private int daysToExpire;

    // Constructor
    public Perishable(String name, double price, int daysToExpire) {
        super(name, price);
        this.daysToExpire = daysToExpire;
    }

    // Getters and setters
    public int getDaysToExpire() {
        return daysToExpire;
    }

    public void setDaysToExpire(int daysToExpire) {
        this.daysToExpire = daysToExpire;
    }

    @Override
    public double calculate(int quantityOfProducts) {
        double amount = super.calculate(quantityOfProducts);

        if (quantityOfProducts == 1)
            amount /= 4;
        else if (quantityOfProducts == 2)
            amount /= 3;
        else if (quantityOfProducts == 3)
            amount /= 2;

        return amount;
    }

    @Override
    public String toString() {
        return "Perishable{" +
                "daysToExpire=" + daysToExpire +
                '}';
    }
}
