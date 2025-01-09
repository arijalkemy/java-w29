package clientes;

import transaccion.Transaccion;

public abstract class Cliente {
    public abstract void realizarTransaccion(Transaccion transaccion);
}
