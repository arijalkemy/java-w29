package ejercicio1.usuarios;

import ejercicio1.transacciones.ConsultaSaldo;
import ejercicio1.transacciones.RetiroEfectivo;

public class Cobrador {
    RetiroEfectivo retiroEfectivo;
    ConsultaSaldo consultaSaldo;

    public Cobrador() {
        this.retiroEfectivo = new RetiroEfectivo();
        this.consultaSaldo = new ConsultaSaldo();
    }

    public void retirarEfectivo(double valor) {
        if (valor < 0){
            this.retiroEfectivo.noOk();
        }else{
            this.retiroEfectivo.ok();
        }
    }

    public void consultarSaldo(double valor) {
        if (valor == -1){
            this.consultaSaldo.noOk();
        }else{
            this.consultaSaldo.ok();
        }
    }




}
