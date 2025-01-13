package EjerciciosInterfaces.Ejercicio1.clases;

import EjerciciosInterfaces.Ejercicio1.interfaces.ConsultaDeSaldo;
import EjerciciosInterfaces.Ejercicio1.interfaces.PagoDeServicios;
import EjerciciosInterfaces.Ejercicio1.interfaces.Retiro;
import EjerciciosInterfaces.Ejercicio1.interfaces.Transaction;

public class Basic extends Client{

    @Override
    public void addTransaction(Transaction t) {
        if(t.getClass() == ConsultaDeSaldo.class
        || t.getClass() == PagoDeServicios.class
        || t.getClass() == Retiro.class) {
            t.transaccionOk();
        } else {
            t.transaccionNoOk();
        }
        getTransactions().add(t);
    }
}
