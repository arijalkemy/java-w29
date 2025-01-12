import model.Guardaropa;
import model.Prenda;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Guardaropa guardaropa = new Guardaropa();

        Prenda prenda1 = new Prenda("Nike", "Remera");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");
        Prenda prenda3 = new Prenda("Nike", "Remera");
        Prenda prenda4 = new Prenda("Adidas", "Pantalón");

        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);
        List<Prenda> prendas2 = Arrays.asList(prenda3, prenda4);
        Integer codigo = guardaropa.guardarPrendas(prendas);
        Integer codigo2 = guardaropa.guardarPrendas(prendas2);

        System.out.println("Código generado: " + codigo);
        System.out.println("Código generado: " + codigo2);

        System.out.println(" ");

        System.out.println("Prendas con el codigo: " + codigo + ":");
        List<Prenda> prendasGuardadas = guardaropa.devolverPrendas(codigo);

        System.out.println(" ");

        System.out.println("Prendas guardadas:");
        prendasGuardadas.forEach(p ->
                System.out.println("Marca: " + p.getMarca() + ", Modelo: " + p.getModelo())
        );

        System.out.println(" ");
        System.out.println("Contenido del guardarropa:");
        guardaropa.mostrarPrendas();

    }
}