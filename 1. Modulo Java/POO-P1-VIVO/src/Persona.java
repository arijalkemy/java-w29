public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public int check() {
        double i = calcularIMC();
        return i < 20 ? -1 : (i < 25 ? 1 : 0);
    }

    public boolean esMayorEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        double c = check();
        String s = c == -1 ? "Bajo peso" : (c == 0 ? "Peso saludable" : "Sobrepeso");
        return String.format("%s[dni: %s] posee -%s-", nombre, dni, s);
    }

}
