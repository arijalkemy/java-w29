import models.GuardaRopa;
import models.Prenda;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        GuardaRopa ropa = new GuardaRopa();

        List<Prenda> prendas = new ArrayList<>();
        Prenda prenda = new Prenda("Adidas","A");
        Prenda prenda2 = new Prenda("Adidas","B");
        Prenda prenda3 = new Prenda("Adidas","C");

        prendas.add(prenda);
        prendas.add(prenda2);
        prendas.add(prenda3);

        System.out.println(ropa.guardarPrendas(prendas));
        System.out.println(ropa.guardarPrendas(prendas));

        System.out.println(ropa.getPrendasGuardada(1));
        System.out.println(ropa.getPrendasGuardada(2));
    }
}