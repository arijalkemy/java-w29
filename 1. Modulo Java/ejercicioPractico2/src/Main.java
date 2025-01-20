public class Main {
    public static void main(String[] args) {
        double sueldoBase = 21000; //monto de ejemplo
        String dni = "12345678"; //dni de ejemplo
        double sueldoConAumento;

        if (sueldoBase > 20000 && sueldoBase <= 45000) {
            sueldoConAumento = sueldoBase + (sueldoBase * 0.1);
        }
        else {
            if (sueldoBase <= 20000){
                sueldoConAumento = sueldoBase + (sueldoBase * 0.2);
            }
            else {
                sueldoConAumento = sueldoBase + (sueldoBase * 0.05);
            }
        }

        System.out.println ("El nuevo sueldo del empleado es de: " + sueldoConAumento);

        /// ///

        int[] serviciosCli = {1,1,2,2,2,1,2}; //vector de 7 posiciones con tipos de servicios
        double totalFactura;

        for (int i = 0; i < serviciosCli.length; i ++) {
            if (i == 1) {
                totalFactura = 1500;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
            else {
                totalFactura = 1500 + 700;
                System.out.println ("El tipo de servicio es: " + serviciosCli[i]);
                System.out.println ("El monto de la factura es de: " + totalFactura);
            }
        }
    }
}