package ej2;

public interface Imprimible<T> {
    default void imprimir(T document) {
        System.out.println("Imprimiendo");
    };
}
