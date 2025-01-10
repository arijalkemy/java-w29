package org.example;

public class Persona {
    /// 1- Creá una clase Persona, la cual tendrá los siguientes atributos: nombre, edad,
    ///dni (en este caso vamos a representarlo como una cadena de caracteres), peso y altura
    ///¿Qué tipo de dato le asignarías a las variables de instancia?
    ///¿Cómo sería la estructura básica de tu clase?

    public String nombre;
    public Integer edad;
    public String dni;
    public double peso;
    public double altura;

    ///2- Vamos a crear diferentes constructores en la clase Persona, uno sin parámetros, el segundo
    ///debe recibir como parámetro nombre, edad y dni; por último creamos un tercero que reciba todos
    ///los atributos de la clase como parámetro.

    public Persona() {
    }

    public Persona(String nombre, Integer edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, Integer edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    /// 5- En la clase Persona implementaremos los siguientes métodos: cacularIMC(), la fórmula para
    ///calcularlo es: peso/(altura^2) - (peso expresado en kg y altura en mts), si este cálculo
    ///devuelve un valor menor que 20, la función debe retornar -1, si devuelve un número entre 20
    ///y 25 inclusive para los dos valores, el método debe retornar un 0, por último, si devuelve
    ///un número mayor que 25 debe retornar un 1. Una vez creado el método anterior,
    ///agreguemos el método esMayorDeEdad() el cual debe retornar una valor booleano, teniendo en
    ///cuenta que la mayoría de edad será considerada en este caso, a partir de los 18 años.
    ///Finalmente agregar un método toString() que va a devolver toda la información de la persona.

    public int calcularIMC(){
        int valorRetorno=0;
        double imc = this.peso/ ( Math.pow(this.altura, 2));
        if (imc<20){
            valorRetorno=-1;
        } else if (imc>=20 && imc<=25){
            valorRetorno=0;
        }else {
            valorRetorno=1;
        }
        return  valorRetorno;
    }

    public boolean esMayorDeEdad(){
        boolean mayorDeEdad=false;
        if (this.edad>=18){
            mayorDeEdad=true;
        }else{
            mayorDeEdad=false;
        }
        return  mayorDeEdad;
    }

    public String toString() {
        String informacion = "Nombre: " +this.nombre+ ", Edad: " +this.edad+ ", DNI: " +this.dni+ ", Peso: " +this.peso+ ", Altura: " +this.altura;
        return informacion;
    }
}
