package EjerciciosInterfaces.Ejercicio1.clases;

import EjerciciosInterfaces.Ejercicio1.interfaces.Deposito;
import EjerciciosInterfaces.Ejercicio1.interfaces.Transaction;
import EjerciciosInterfaces.Ejercicio1.interfaces.Transferencia;

public class Ejecutivos extends Client implements Deposito,Transferencia{

    @Override
    public void addTransaction(Transaction t) {
        if(t.getClass() == Transferencia.class
        || t.getClass() == Deposito.class) {
            t.transaccionOk();
        } else {
            t.transaccionNoOk();
        }
        getTransactions().add(t);
    }
    
    @Override
    public void depositar(double monto){
        System.out.println("Se ha depositado: " + monto);
    }

    @Override
    public void transferir(double monto, String destino){
        System.out.println("Se ha transferido: " + monto + " a: " + destino);
    }
    @Override
    public void transaccionOk(){
        System.out.println("Transacción ejecutada con éxito.");
    }

    @Override
    public void transaccionNoOk(){
        System.out.println("Error en la transacción.");
    }
}
