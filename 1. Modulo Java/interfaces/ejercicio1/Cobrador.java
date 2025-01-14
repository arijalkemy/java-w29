package ejercicio1;

public class Cobrador implements Transacciones {

    @Override
    public String retiro() {
        System.out.println("El cobrador retira efectivo");
        return transaccionOk();
    }

    @Override
    public String consultaSaldo() {
        System.out.println("El cobrador consulta saldo");
        return transaccionOk();
    }

    @Override
    public String deposito() {
        System.out.println("El cobrador no puede realizar depósitos");
        return transaccionNoOk();
    }

    @Override
    public String transferencia() {
        System.out.println("El cobrador no puede realizar transferencias");
        return transaccionNoOk();
    }

    @Override
    public String pagoServicios() {
        System.out.println("El cobrador no puede pagar servicios");
        return transaccionNoOk();
    }

    @Override
    public String transaccionOk() {
        return ("El cobrador hace una transacción exitosa");
    }

    @Override
    public String transaccionNoOk() {
        return ("El cobrador falló la transacción");
    }
}