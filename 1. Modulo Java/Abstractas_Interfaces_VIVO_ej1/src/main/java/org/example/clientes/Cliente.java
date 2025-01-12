package org.example.clientes;

import org.example.tipos.*;

public class Cliente {
    public void consulta() {
        new Consulta().transaccionIncorrecta();
    };
    public void deposito() {
        new Deposito().transaccionIncorrecta();
    };
    public void pagosServicio() {
        new PagosServicio().transaccionIncorrecta();
    };
    public void retiro() {
        new Retiro().transaccionIncorrecta();
    };
    public void transferencia() {
        new Transferencia().transaccionIncorrecta();
    };
}
