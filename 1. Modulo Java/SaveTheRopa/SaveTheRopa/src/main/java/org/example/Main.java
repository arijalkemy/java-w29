package org.example;

import org.example.model.Guardarropa;
import org.example.model.Prenda;

public class Main {
    public static void main(String[] args) {

        Guardarropa miGuardarropa = new Guardarropa();
        Prenda nikeAirMax = new Prenda("Nike", "Air Max");
        Prenda adidasSuperstar = new Prenda("Adidas", "Superstar");
        Prenda pumaSuede = new Prenda("Puma", "Suede");
        Prenda reebokClassic = new Prenda("Reebok", "Classic");
        Prenda converseChuckTaylor = new Prenda("Converse", "Chuck Taylor");
        Prenda levi501 = new Prenda("Levi's", "501");
        Prenda gucciAce = new Prenda("Gucci", "Ace");
        Prenda pradaGalleria = new Prenda("Prada", "Galleria");
        Prenda vansOldSkool = new Prenda("Vans", "Old Skool");
        Prenda calvinKleinModern = new Prenda("Calvin Klein", "Modern");
        Prenda burberryTrench = new Prenda("Burberry", "Trench");
        Prenda armaniExchange = new Prenda("Armani", "Exchange");

        miGuardarropa.guardarPrendas(adidasSuperstar);
        miGuardarropa.guardarPrendas(levi501, nikeAirMax, reebokClassic);
        Integer codigo = miGuardarropa.guardarPrendas(nikeAirMax, adidasSuperstar);
        System.out.println("Mis prendas Nike y Adidas se guardaron bajo el código: " + codigo);
        miGuardarropa.guardarPrendas(gucciAce);
        miGuardarropa.guardarPrendas(pradaGalleria, vansOldSkool, calvinKleinModern, burberryTrench, armaniExchange);
        miGuardarropa.mostrarPrendas();

        miGuardarropa.mostrarPrendas(codigo);
    }
}