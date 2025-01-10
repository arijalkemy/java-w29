package org.example;

import org.example.model.Basico;
import org.example.model.Cobrador;
import org.example.model.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo e = new Ejecutivo("Eliana", 1234, 1000.0);
        Basico b = new Basico("Salma", 5677, 2000.0);
        Cobrador c = new Cobrador("Selena", 3457, 3000.0);

        e.depositar(5000.0);
        e.transferir(10000.0);
        e.transferir(50.0);
        System.out.println("\n");
        b.consultarSaldo();
        b.pagarServicios(2000.0);
        b.retirarEfectivo(50.0);
        System.out.println("\n");
        c.consultarSaldo();
        c.retirarEfectivo(300.0);
    }
}