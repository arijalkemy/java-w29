package ejercicio1;

public class Ejecutivo implements Transacciones {

    @Override
    public String deposito() {
        System.out.println("El ejecutivo hace un deposito");
        return transaccionOk();
    }

    @Override
    public String transferencia() {
        System.out.println("El ejecutivo hace una transferencia");
        return transaccionOk();
    }

    // Métodos no permitidos para Ejecutivo
    @Override
    public String retiro() {
        System.out.println("El ejecutivo no puede realizar retiros");
        return transaccionNoOk();
    }

    @Override
    public String consultaSaldo() {
        System.out.println("El ejecutivo no puede consultar saldos");
        return transaccionNoOk();
    }

    @Override
    public String pagoServicios() {
        System.out.println("El ejecutivo no puede hacer pagos de servicios");
        return transaccionNoOk();
    }

    @Override
    public String transaccionOk() {
        return ("El ejecutivo hace una transaccion exitosa");
    }

    @Override
    public String transaccionNoOk() {
        return ("El ejecutivo falló la transaccion");
    }
}