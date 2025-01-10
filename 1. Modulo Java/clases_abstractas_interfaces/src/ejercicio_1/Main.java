package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito(1000.0);
        ejecutivo.realizarTransferencia(2000.0, "4535432142");

        Basico basico = new Basico();
        basico.pagarServicio("Internet", 500.0);
        basico.realizarRetiroEfectivo(200.0);
        basico.consultarSaldo();

        Cobrador cobrador = new Cobrador();
        cobrador.realizarRetiroEfectivo(200.0);
        cobrador.consultarSaldo();
    }
}
