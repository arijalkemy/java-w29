package org.example.poo.part2;

import org.example.poo.part2.Interface.ConsultaDeSaldo;
import org.example.poo.part2.Interface.PagoDeServicios;
import org.example.poo.part2.Interface.RetiroDeEfectivo;

public class Basic implements ConsultaDeSaldo, RetiroDeEfectivo, PagoDeServicios {
    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo...");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pagando servicio...");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }
}
