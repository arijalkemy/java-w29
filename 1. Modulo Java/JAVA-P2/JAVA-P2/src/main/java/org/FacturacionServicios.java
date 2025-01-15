package org;

public class FacturacionServicios {
    public static void main(String[] args) {
        // Constantes para los precios de los servicios
        final int PRECIO_CAMARAS = 1500;
        final int PRECIO_PATRULLAJE = 700;

        // Vector que almacena el tipo de servicio adquirido por cada cliente
        // 1 para "Seguridad con cámaras" y 2 para "Seguridad con cámaras + patrullaje"
        int[] tipoServicios = {1, 2, 1, 2, 1, 2, 1};

        // Vector para almacenar los montos finales de las facturas
        int[] montosFinales = new int[tipoServicios.length];

        // Calcular el monto final para cada cliente
        for (int i = 0; i < tipoServicios.length; i++) {
            if (tipoServicios[i] == 1) {
                montosFinales[i] = PRECIO_CAMARAS;
            } else if (tipoServicios[i] == 2) {
                montosFinales[i] = PRECIO_CAMARAS + PRECIO_PATRULLAJE;
            }
        }

        // Mostrar los montos finales de las facturas
        for (int i = 0; i < montosFinales.length; i++) {
            System.out.println("Cliente " + (i + 1) + " - Monto final: $" + montosFinales[i]);
        }
    }
}
