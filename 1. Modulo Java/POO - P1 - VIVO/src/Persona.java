public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC() {
        float imc = peso / (altura * altura);

        if (imc < 20) {
            return -1;
        }

        if (imc >= 20 && imc <= 25) {
            return 0;
        }

        return 1;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Datos de persona: " + '\n' +
                "nombre: " + nombre + '\n' +
                "edad: " + edad + '\n' +
                "dni: " + dni + '\n' +
                "peso: " + peso + '\n' +
                "altura: " + altura;
    }
}
