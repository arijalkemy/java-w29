package org.Ej1;

public class Ejercicio1 {

    // Método estático para ordenar un arreglo usando el algoritmo de burbuja
    public static int[] burbuja(int[] array) {
        int n = array.length; // Longitud del arreglo
        boolean intercambio;

        // Bucle externo: controla las pasadas
        for (int paso = 0; paso < n - 1; paso++) {
            intercambio = false;

            // Bucle interno: compara elementos adyacentes
            for (int i = 0; i < n - paso - 1; i++) {
                // Intercambiar si no están en orden
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    intercambio = true;
                }
            }

            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!intercambio) {
                break;
            }
        }

        return array; // Devuelve el arreglo ordenado
    }

    // Método para imprimir un arreglo
    public static void imprimirArreglo(int[] array) {
        for (int elemento : array) {
            System.out.print(elemento + " ");
        }
        System.out.println(); // Salto de línea al final
    }

    // Método principal
    public static void main(String[] args) {
        // Definir un arreglo
        int[] array = {5, 2, 9, 1, 5, 6};

        // Ordenar el arreglo
        burbuja(array);

        // Imprimir el arreglo ordenado
        imprimirArreglo(array);
    }
}

