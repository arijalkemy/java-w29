package clientes;

import transaccion.ConsultarSaldo;
import transaccion.PagoServicios;
import transaccion.RetiroEfectivo;
import transaccion.Transaccion;

public class Basico extends Cliente {
    @Override
    public void realizarTransaccion(Transaccion transaccion) {
        if(transaccion instanceof ConsultarSaldo || transaccion instanceof PagoServicios || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOK();
        }else{
            transaccion.transaccionNoOk();
        }
    }
}
