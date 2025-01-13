package org.example;

public class Distributor {
    public static void main(String[] args) {

        // Ejercicio 1
        ExceptionsPractice practice = new ExceptionsPractice();
        practice.coefficientCalculation();

        // Ejercicio 2
        double totalAmount = 0;

        Product[] products = new Product[5];
        products[0] = new Product("Manzana", 2500);
        products[1] = new Product("Pera", 1200);
        products[2] = new Product("Arroz", 2850);
        products[3] = new Product("Carne", 16450);
        products[4] = new Product("Pasta", 5340);

        for (int i = 0; i < products.length; i++)
        {
            totalAmount += products[i].calculate(5);
        }

        System.out.println("Precio total: " + totalAmount);

    }
}