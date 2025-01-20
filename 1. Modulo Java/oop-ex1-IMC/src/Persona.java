public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float altura;
    private float peso;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }
    public Persona(String nombre, int edad, String dni, float altura, float peso){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
    }


    public int calcularIMC(){
        int imc= -1;
        double result= this.peso/(Math.pow(this.altura,2));

        if (result>= 20 && result <=25){
            imc = 0;
        }else if (result > 25){
            imc = 1;
        }
        return imc;
        // return calculo < 20 ? -1 : calculo <= 25 ? 0 : 1;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    public String toString(){
        return "{nombre:" + this.nombre +", edad:" + this.edad +", dni:" + this.dni +", altura:" + this.altura
                +", peso:" + this.peso + "}";
    }
}
