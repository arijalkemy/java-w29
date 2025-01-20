package clientes;

import transacciones.ConsultaDeSaldos;
import transacciones.PagoDeServicios;
import transacciones.RetiroDeDinero;

public class Basico {
    public void consultaDeSaldo(){
        ConsultaDeSaldos consulta = new ConsultaDeSaldos();
        consulta.doTransaction();
    }

    public void pagoDeServicios(){
        PagoDeServicios pago = new PagoDeServicios();
        pago.doTransaction();
    }

    public void retiroDeEfectivo(){
        RetiroDeDinero retiro = new RetiroDeDinero();
        retiro.doTransaction();
    }
}
