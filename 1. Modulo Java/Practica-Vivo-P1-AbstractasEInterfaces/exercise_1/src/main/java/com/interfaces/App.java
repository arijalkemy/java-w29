package com.interfaces;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo("test1");
        Cliente basico = new Basico("test2");
        Cliente cobrador = new Cobrador("test3");

        Transaccionable deposito = new Deposito();
        Transaccionable tranferencia = new Transferencia();
        Transaccionable retiro = new Retiro();
        Transaccionable consultaSaldo = new ConsultaSaldo();
        Transaccionable pagoServicios = new PagoServicios();

        deposito.realizarTransaccion(ejecutivo);
        deposito.realizarTransaccion(cobrador);
        deposito.realizarTransaccion(basico);

        tranferencia.realizarTransaccion(ejecutivo);
        tranferencia.realizarTransaccion(cobrador);
        tranferencia.realizarTransaccion(basico);

        retiro.realizarTransaccion(ejecutivo);
        retiro.realizarTransaccion(cobrador);
        retiro.realizarTransaccion(basico);

        consultaSaldo.realizarTransaccion(ejecutivo);
        consultaSaldo.realizarTransaccion(cobrador);
        consultaSaldo.realizarTransaccion(basico);

        pagoServicios.realizarTransaccion(ejecutivo);
        pagoServicios.realizarTransaccion(cobrador);
        pagoServicios.realizarTransaccion(basico);
    }
}
