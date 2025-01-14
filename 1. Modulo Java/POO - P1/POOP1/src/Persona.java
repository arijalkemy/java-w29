//Sala 9
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

    public Persona(String nombre, double altura, int edad, String dni, double peso) {
        this.nombre = nombre;
        this.altura = altura;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre +
                "\nEdad:" + edad +
                "\nDNI:" + dni +
                "\nPeso:" + peso +
                "\nAltura:" + altura ;
    }


    public int calcularIMC() {
        double imc = peso / (Math.pow(altura,2.0));
        if(imc < 20){
            return -1;
        } else if (imc <=25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        if(edad > 18){
            return true;
        }
        return false;
    }
}
