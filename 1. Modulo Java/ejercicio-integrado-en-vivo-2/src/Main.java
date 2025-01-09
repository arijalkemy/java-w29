import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Prenda remera = new Prenda(Prenda.Tipo.REMERA,"Adidas","42 estaciones");
        Prenda pantalon = new Prenda(Prenda.Tipo.PANTALON,"Las locas","45 decadas");

        GuardaRopa guardaRopa = new GuardaRopa();
        Integer codigo = guardaRopa.guardarPrendas(Arrays.asList(remera, pantalon));
        System.out.println("Tu codigo es: " + codigo);

        List<Prenda> lalista = guardaRopa.devolverPrendas(codigo);
        for(Prenda p : lalista) {
            System.out.println(p);
        }
    }
}