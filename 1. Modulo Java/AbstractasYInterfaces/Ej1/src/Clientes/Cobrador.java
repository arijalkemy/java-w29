package Clientes;


import Operaciones.ConsultaSaldo;
import Operaciones.RetiroEfectivo;

public class Cobrador {
    private RetiroEfectivo retiroEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobrador() {
        this.retiroEfectivo = new RetiroEfectivo();
        this.consultaSaldo = new ConsultaSaldo();
    }

    public void realizarRetiroEfectivo() {
        retiroEfectivo.transaccionOk();
    }

    public void realizarConsultaSaldo() {
        consultaSaldo.transaccionOk();
    }
}