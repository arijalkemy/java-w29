package ej3;

public interface Carnivoro {
    default void comerCarne() {
        System.out.println("Comiendo carne");
    };
}
