package ejercicio1.usuarios;

import ejercicio1.transacciones.ConsultaSaldo;
import ejercicio1.transacciones.PagoServicios;
import ejercicio1.transacciones.RetiroEfectivo;

public class Basico {
    PagoServicios pagoServicios;
    ConsultaSaldo consultaSaldo;
    RetiroEfectivo retiroEfectivo;

    public Basico() {
        this.pagoServicios = new PagoServicios();
        this.consultaSaldo = new ConsultaSaldo();
        this.retiroEfectivo = new RetiroEfectivo();
    }

    public void pagarServicio(double cantidad) {
        if (cantidad <= 0) {
            this.pagoServicios.noOk();
        }else{
            this.pagoServicios.ok();
        }
    }

    public void consultarSaldo(double valor) {
        if (valor == -1){
            this.consultaSaldo.noOk();
        }else{
            this.consultaSaldo.ok();
        }
    }

    public void retirarEfectivo(double valor) {
        if (valor < 0){
            this.retiroEfectivo.noOk();
        }else{
            this.retiroEfectivo.ok();
        }
    }
}
