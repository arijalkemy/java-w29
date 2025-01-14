package poo_p1;

public class Persona {
  String nombre;
  int edad;
  String dni;
  Double peso;
  Double altura;

  public Persona() {
    this.nombre = "";
    this.edad = 0;
    this.peso = 0.0;
    this.altura = 0.0;
    this.dni = "";
  }

  public Persona(String nombre, int edad, String dni){
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
  }

  public Persona(String nombre, int edad, String dni, Double peso, Double altura){
    this.nombre = nombre;
    this.edad = edad;
    this.dni = dni;
    this.peso = peso;
    this.altura = altura;
  }

  public int calcularIMC(){
    double mc = this.peso/(java.lang.Math.pow(this.altura, 2));
    if(mc < 20) return -1;
    else if(mc >= 20 && mc <= 25) return 0;
    else return 1;
  }

  public boolean esMayorDeEdad(){
    return this.edad >= 18;
  }

  public String toString(){
    return "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nDNI: " + this.dni + "\nPeso: " + this.peso + "\nAltura: " + this.altura;
  }
}