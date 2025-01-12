package org.example.tipos;

import org.example.clientes.Transaccion;

public class PagosServicio implements Transaccion {
    @Override
    public void transaccionCorrecta() {
        System.out.println("Pago de servicio exitoso.");
    }

    @Override
    public void transaccionIncorrecta() {
        System.out.println("Pago de servicio no exitoso.");
    }
}
