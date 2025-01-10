package org.example.clases;

public class Main {
    public static void main(String[] args) {
        //Una vez realizado lo mencionado, llevar a cabo en el Main la creación de diferentes animales y la
        // invocación de sus respectivas implementaciones de métodos.

        Perro perro = new Perro();
        perro.comerCarne();
        perro.emitirSonido();

        Gato gato = new Gato();
        gato.comerCarne();
        gato.emitirSonido();

        Vaca vaca = new Vaca();
        vaca.comerHierba();
        vaca.emitirSonido();


        //Como propuesta extra se sugiere llamar a un método comerAnimal donde a partir del pasaje de un
        //objeto de cualquier tipo de animal como parámetro, invoque al método para comer según corresponda
        // a dicho animal.


    }
}