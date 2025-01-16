import classes.Basico;
import classes.Cobrador;
import classes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerDeposito();
        ejecutivo.transaccionNoOk();

        Basico basico = new Basico();
        basico.consultarSaldo();
        basico.pagarServicios();

        Cobrador cobradores = new Cobrador();
        cobradores.retirarEfectivo();
        cobradores.consultarSaldo();
    }
}