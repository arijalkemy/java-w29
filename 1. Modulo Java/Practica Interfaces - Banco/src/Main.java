public class Main {
    public static void main(String[] args) {

        Cliente ejecutivo = new Ejecutivo();
        Cliente basic = new Basico();
        Cliente cobrador = new Cobrador();

        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Transferencia();
        Transaccion retiro = new RetiroEfectivo();
        Transaccion consulta = new ConsultaSaldo();
        Transaccion pago = new PagoServicio();

        // Test Ejecutivo
        System.out.println("Ejecutivo:");
        ejecutivo.realizarTransaccion(deposito);
        ejecutivo.realizarTransaccion(transferencia);
        ejecutivo.realizarTransaccion(retiro); // No permitido
        System.out.println();

        // Test Basic
        System.out.println("Cliente Basic:");
        basic.realizarTransaccion(consulta);
        basic.realizarTransaccion(pago);
        basic.realizarTransaccion(retiro);
        basic.realizarTransaccion(deposito); // No permitido
        System.out.println();

        // Test Cobrador
        System.out.println("Cobrador:");
        cobrador.realizarTransaccion(retiro);
        cobrador.realizarTransaccion(consulta);
        cobrador.realizarTransaccion(pago);
    }
}