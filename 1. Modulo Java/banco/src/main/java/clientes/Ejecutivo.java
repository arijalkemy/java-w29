package clientes;

import transaccion.Deposito;
import transaccion.Transaccion;
import transaccion.Transferencia;

public class Ejecutivo extends Cliente {
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.transaccionOK();
        }else{
            transaccion.transaccionNoOk();
        }
    }
}
