public class Persona {
    public String Nombre;
    public Integer Edad;
    public String Dni;
    public Double Peso;
    public Double Altura;

    public Persona() {}

    public Persona(String nombre, Integer edad, String dni) {
        Nombre = nombre;
        Edad = edad;
        Dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, Double peso, Double altura) {
        Nombre = nombre;
        Edad = edad;
        Dni = dni;
        Peso = peso;
        Altura = altura;
    }

    public Double calcularIMC() {
        if (Peso == null || Altura == null || Altura == 0) {
            throw new IllegalArgumentException("Peso y Altura deben tener valores válidos.");
        }

        Double imc = Peso / (Altura * Altura);

        if (imc < 20) {
            return -1.0;
        } else if (imc >= 20 && imc <= 25) {
            return 0.0;
        } else {
            return 1.0;
        }
    }

    public Boolean esMayorDeEdad() {
        if (Edad == null) {
            throw new IllegalArgumentException("Edad debe tener un valor válido.");
        }

        return Edad >= 18;
    }
}