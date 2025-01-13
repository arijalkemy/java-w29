public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double altura;
    private double peso;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double altura, double peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }

    public int calcularIMC(){
        double imc = this.peso/ ( Math.pow(this.altura, 2));
        if(imc < 20){
            return -1;
        }else if(imc >= 20 && imc <= 25){
            return 0;
        }
        return 1;
    }

    public boolean esMayorEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Nombre:" + this.nombre + "\nEdad: " + this.edad + "\nDNI: " + this.dni + "\nAltura: " + this.altura + "\nPeso: " + this.peso;
    }
}
