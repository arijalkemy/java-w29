package EjerciciosInterfaces.Ejercicio1.clases;

import java.util.ArrayList;
import java.util.List;

import EjerciciosInterfaces.Ejercicio1.interfaces.Transaction;

public abstract class Client {
    private List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Client() {
        transactions = new ArrayList<>();
    }

    public abstract void addTransaction(Transaction t);
}
