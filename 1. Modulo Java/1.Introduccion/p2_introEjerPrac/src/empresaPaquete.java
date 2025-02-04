public class empresaPaquete {
    public static void main(String[] args) {
        double sueldoBase = 2100;
        String dni = "12345678";
        double sueldoConAumento;

        if (sueldoBase <= 20000) {
            sueldoConAumento = sueldoBase * 1.20;
        } else if (sueldoBase <= 45000) {
            sueldoConAumento = sueldoBase * 1.10;
        } else {
            sueldoConAumento = sueldoBase * 1.05;
        }

        System.out.println("El nuevo sueldo del empleado con DNI " + dni + " es de: $" + sueldoConAumento);
    }
}
