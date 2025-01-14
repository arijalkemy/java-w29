package ejercicio1;

public class Basico implements Transacciones {

    @Override
    public String retiro() {
        System.out.println("El cliente básico retira efectivo");
        return transaccionOk();
    }

    @Override
    public String consultaSaldo() {
        System.out.println("El cliente básico consulta saldo");
        return transaccionOk();
    }

    @Override
    public String pagoServicios() {
        System.out.println("El cliente básico paga servicios");
        return transaccionOk();
    }

    // Métodos no permitidos para Basico
    @Override
    public String deposito() {
        System.out.println("El cliente básico no puede realizar depósitos");
        return transaccionNoOk();
    }

    @Override
    public String transferencia() {
        System.out.println("El cliente básico no puede realizar transferencias");
        return transaccionNoOk();
    }

    @Override
    public String transaccionOk() {
        return ("El cliente básico hace una transacción exitosa");
    }

    @Override
    public String transaccionNoOk() {
        return ("El cliente básico falló la transacción");
    }
}