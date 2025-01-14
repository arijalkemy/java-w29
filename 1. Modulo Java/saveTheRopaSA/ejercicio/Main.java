package ejercicio;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de prendas
        Prenda prenda1 = new Prenda("Nike", "Zapatillas");
        Prenda prenda2 = new Prenda("Adidas", "Camisa");

        // Crear una lista de prendas
        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);

        // Crear una instancia de GuardaRopa
        guardarRopa guardaRopa = new guardarRopa();

        // Guardar las prendas y recibir un identificador
        Integer identificador = guardaRopa.guardarPrendas(prendas);
        System.out.println("Prendas guardadas con identificador: " + identificador);

        // Mostrar todas las prendas almacenadas
        guardaRopa.mostrarPrendas();

        // Recuperar las prendas usando el identificador
        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(identificador);
        System.out.println("Prendas recuperadas: " + prendasRecuperadas);
    }
}