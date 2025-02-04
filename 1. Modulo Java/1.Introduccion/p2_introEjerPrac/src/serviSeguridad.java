public class serviSeguridad {
    public static void main(String[] args) {
        int[] serviciosCli = {1, 1, 2, 2, 2, 1, 2};
        double totalFactura;

        for (int i = 0; i < serviciosCli.length; i++) {
            if (serviciosCli[i] == 1) {
                totalFactura = 1500;
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println("El monto de la factura es de: $" + totalFactura);
            } else if (serviciosCli[i] == 2) {
                totalFactura = 1500 + 700;
                System.out.println("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println("El monto de la factura es de: $" + totalFactura);
            } else {
                System.out.println("Tipo de servicio no válido para el cliente en la posición " + i);
            }
        }
    }
}
