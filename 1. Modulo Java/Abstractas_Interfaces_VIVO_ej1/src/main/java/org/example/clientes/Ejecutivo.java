package org.example.clientes;

import org.example.tipos.Deposito;
import org.example.tipos.Transferencia;

public class Ejecutivo extends Cliente {
    @Override
    public void deposito() {
        new Deposito().transaccionCorrecta();
    }

    @Override
    public void transferencia() { new Transferencia().transaccionCorrecta(); }
}
