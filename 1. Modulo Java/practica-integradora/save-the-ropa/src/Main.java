import java.util.*;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();


        Prenda prenda1 = new Prenda("Levi", "Camiseta");
        Prenda prenda2 = new Prenda("Gucci", "Pantalón");


        List<Prenda> listaDePrendas = new ArrayList<>();
        listaDePrendas.add(prenda1);
        listaDePrendas.add(prenda2);


        Integer codigo = guardaRopa.guardaPrendas(listaDePrendas);
        System.out.println("Prendas guardadas con el código: " + codigo);


        System.out.println("Prendas en el guardarropas:");
        guardaRopa.mostarPrendas();


        List<Prenda> prendasDevueltas = guardaRopa.devolverPrendas(codigo);
        System.out.println("Prendas devueltas: " + prendasDevueltas);


        System.out.println("Prendas en el guardarropas después de devolver prendas:");
        guardaRopa.mostarPrendas();
    }

}