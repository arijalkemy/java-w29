package Clientes;

import Operaciones.ConsultaSaldo;
import Operaciones.PagoServicios;
import Operaciones.RetiroEfectivo;

public class Basic {
    private ConsultaSaldo consultaSaldo;
    private PagoServicios pagoServicios;
    private RetiroEfectivo retiroEfectivo;

    public Basic() {
        this.consultaSaldo = new ConsultaSaldo();
        this.pagoServicios = new PagoServicios();
        this.retiroEfectivo = new RetiroEfectivo();
    }

    public void realizarConsultaSaldo() {
        consultaSaldo.transaccionOk();
    }

    public void realizarPagoServicios() {
        pagoServicios.transaccionOk();
    }

    public void realizarRetiroEfectivo() {
        retiroEfectivo.transaccionOk();
    }
}