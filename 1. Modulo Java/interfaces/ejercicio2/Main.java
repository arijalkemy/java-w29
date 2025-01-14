package ejercicio2;

public class Main {
    public static void main(String[] args) {
        PDF libro = new PDF("Horror", "King", 850, "Ojos de Fuego");
        System.out.println(libro.imprimir());
        Informe informe = new Informe("Edwin", "Martín", 3500, 23);
        System.out.println(informe.imprimir());
        String[] atributos = {"Experiencia en Java", "Desarrollo web", "Ingles avanzado"};
        String carrera = "Ingeniería en Sistemas";
        String nombre = "Juan Perez";

        Curriculum candidato = new Curriculum(atributos, carrera, nombre);
        System.out.println(candidato.imprimir());
    }
}
