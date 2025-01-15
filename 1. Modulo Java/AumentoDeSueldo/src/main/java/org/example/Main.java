package org.example;

public class Main {
    public static void main(String[] args) {
        int sueldo = 200000;
        int dni = 2020202;
        int sueldoAumentado;

        if (sueldo <= 20000) {
            sueldoAumentado = (int) (sueldo * 1.2);
        } else if (sueldo > 20000 || sueldo == 45000) {
            sueldoAumentado = (int) (sueldo * 1.1);
        } else if (sueldo > 45000) {
            sueldoAumentado = (int) (sueldo * 1.05);
        } else {
            sueldoAumentado = sueldo;
        }

        System.out.println("El nuevo sueldo del empleado es: " + sueldoAumentado);
    }
}