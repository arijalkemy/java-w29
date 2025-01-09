package clientes;

import transaccion.ConsultarSaldo;
import transaccion.RetiroEfectivo;
import transaccion.Transaccion;

public class Cobradores extends Cliente {

    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof RetiroEfectivo || transaccion instanceof ConsultarSaldo){
            transaccion.transaccionOK();
        }else{
            transaccion.transaccionNoOk();
        }
    }
}
