package ejercicio1;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de cada tipo de cliente
        Ejecutivo ejecutivo = new Ejecutivo();
        Basico basico = new Basico();
        Cobrador cobrador = new Cobrador();

        // Mostrar transacciones del Ejecutivo
        System.out.println("Transacciones del Ejecutivo:");
        ejecutivo.deposito();
        ejecutivo.transferencia();
        System.out.println(ejecutivo.retiro());
        System.out.println();

        // Mostrar transacciones del Cliente Básico
        System.out.println("Transacciones del Cliente Básico:");
        basico.retiro();
        basico.consultaSaldo();
        basico.pagoServicios();
        System.out.println(basico.deposito());
        System.out.println();

        // Mostrar transacciones del Cobrador
        System.out.println("Transacciones del Cobrador:");
        cobrador.retiro();
        cobrador.consultaSaldo();
        System.out.println(cobrador.transferencia());
        System.out.println(cobrador.pagoServicios());
    }
}