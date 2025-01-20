package clientes;

import transacciones.ConsultaDeSaldos;
import transacciones.RetiroDeDinero;

public class Colaborador {
    public void retiroDeEfectivo(){
        RetiroDeDinero retiro = new RetiroDeDinero();
        retiro.doTransaction();
    }

    public void consultaDeSaldo(){
        ConsultaDeSaldos consulta = new ConsultaDeSaldos();
        consulta.doTransaction();
    }
}
