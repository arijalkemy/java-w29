
public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    private double peso;
    private double altura;

    public Persona(String nombre, int edad, int dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }
    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    //peso/(altura^2) - (peso expresado en kg y altura en mts), si este cálculo devuelve un valor menor que 20, la función debe retornar -1,
//si devuelve un número entre 20 y 25 inclusive para los dos valores, el métod o debe retornar un 0, por último, si devuelve un número
//mayor que 25 debe retornar un 1
    public int calcularIMC(){
        double imc = 0;
        imc = (peso / (Math.pow(altura, 2))) - peso - altura;
        if(imc < 20){
            return -1;
        }else if(imc <= 25){
            return 0;
        }else{
            return 1;
        }
    }
    //el métod o esMayorDeEdad() el cual debe retornar una valor booleano, teniendo
    // en cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años.

    public Boolean esMayorDeEdad(){
        if(edad > 18){
            return true;
        }else{
            return false;
        }
    }
    //toString() que va a devolver toda la información de la persona.
    public String toString(){
        String a = "Los datos de la persona son: nombre "+ nombre + "edad: "+edad+"dni: "+dni;
        return a;
    }
}
