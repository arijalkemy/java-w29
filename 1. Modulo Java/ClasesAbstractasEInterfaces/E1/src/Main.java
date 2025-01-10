public class Main {
    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo("Erik");
        Cliente basic = new Basico("Jonathan");
        Cliente cobrador = new Cobrador("Renata");

        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Transferencia();
        Transaccion retiro = new RetiroEfectivo();
        Transaccion consultaSaldo = new ConsultaSaldo();
        Transaccion pagoServicios = new PagoServicios();


        System.out.println("Operaciones del cliente ejecutivo: " + ejecutivo.getNombre());
        //transaccionOk
        ejecutivo.realizarTransaccion(deposito);
        ejecutivo.realizarTransaccion(transferencia);
        //transaccionNoOk
        ejecutivo.realizarTransaccion(consultaSaldo);
        ejecutivo.realizarTransaccion(pagoServicios);
        ejecutivo.realizarTransaccion(retiro);


        System.out.println("\nOperaciones del cliente basico: " + basic.getNombre());
        //transaccionOk
        basic.realizarTransaccion(consultaSaldo);
        basic.realizarTransaccion(pagoServicios);
        basic.realizarTransaccion(retiro);
        //transaccionNoOk
        basic.realizarTransaccion(deposito);
        basic.realizarTransaccion(transferencia);

        System.out.println("\nOperaciones del cliente cobrador: " + cobrador.getNombre());
        //transaccionOk
        cobrador.realizarTransaccion(retiro);
        cobrador.realizarTransaccion(consultaSaldo);
        //transaccionNoOk
        cobrador.realizarTransaccion(pagoServicios);
        cobrador.realizarTransaccion(transferencia);
        cobrador.realizarTransaccion(deposito);
    }
}