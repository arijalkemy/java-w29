public class Main {
  public static void main(String[] args) {
    Persona persona_void = new Persona();
    Persona persona_partial = new Persona("Juan", 25, "12345678A");
    Persona persona_full = new Persona("Juan", 25, "12345678A", 70.0, 1.75);

    int imc = persona_full.calcularIMC();
    if(imc == -1) System.out.println("La persona está por debajo de su peso ideal");
    else if(imc == 0) System.out.println("La persona está en su peso ideal");
    else System.out.println("La persona está por encima de su peso ideal");
    if(persona_full.esMayorDeEdad()) System.out.println("La persona es mayor de edad");
    else System.out.println("La persona es menor de edad");
    System.out.println(persona_full.toString());
  }
}
