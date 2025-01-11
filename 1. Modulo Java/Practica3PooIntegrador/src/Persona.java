public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
    }

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

    public double cacularIMC(double peso, double altura) {
        double imc = peso / (altura * altura);
        if (imc < 20.0) {
            return -1;
        }else if(imc > 20.0 && imc < 25.0) {
            return 0;
        }else if(imc > 25.0) {
            return 1;
        }
        return imc;
    }

    public boolean esMayorDeEdad(int edad) {
        return (edad >= 18);
    }

    public String toStringData() {
        return "Nombre: " + nombre + " Edad: " + edad + " DNI: " + dni + " Peso: " + peso + " Altura: " + altura;
    }

}
