public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona("Matias", 26, "12345", 40, 1.50);
        Persona p2 = new Persona("Lucas", 20, "6789", 70, 1.90);
        Persona p3 = new Persona("Matias", 26, "10111213", 110, 1.95);

        System.out.println(p1);
        System.out.printf("¿Es mayor de edad? %s%n", p1.esMayorEdad() ? "Si" : "No");

        System.out.println(p2);
        System.out.printf("¿Es mayor de edad? %s%n", p2.esMayorEdad() ? "Si" : "No");

        System.out.println(p3);
        System.out.printf("¿Es mayor de edad? %s%n", p3.esMayorEdad() ? "Si" : "No");

    }
}