package org;

import java.util.Scanner;

public class ActualizacionSueldos {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Solicitar el DNI del empleado
            System.out.print("Ingrese el DNI del empleado: ");
            String dni = scanner.nextLine();

            // Solicitar el sueldo actual del empleado
            System.out.print("Ingrese el sueldo actual del empleado: ");
            double sueldo = scanner.nextDouble();

            // Variable para calcular el nuevo sueldo
            double nuevoSueldo = sueldo;

            // Determinar el porcentaje de aumento según las condiciones
            if (sueldo <= 20000) {
                nuevoSueldo = sueldo * 1.20; // Aumento del 20%
                System.out.println("Al empleado con DNI " + dni + " le corresponde un aumento del 20%.");
            } else if (sueldo <= 45000) {
                nuevoSueldo = sueldo * 1.10; // Aumento del 10%
                System.out.println("Al empleado con DNI " + dni + " le corresponde un aumento del 10%.");
            } else {
                nuevoSueldo = sueldo * 1.05; // Aumento del 5%
                System.out.println("Al empleado con DNI " + dni + " le corresponde un aumento del 5%.");
            }

            // Mostrar el sueldo actualizado
            System.out.println("El nuevo sueldo del empleado es: $" + nuevoSueldo);

            scanner.close();
        }
}
