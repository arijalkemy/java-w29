package com.example;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        int opcion;

        do {
            opcion = controller.mostrarMenu();

            switch (opcion) {
                case 1 -> {
                    int categoria = controller.pedirEntero("Ingrese una categoría");
                    controller.mostrarInscripciones(categoria - 1);
                }
                case 2 -> controller.crearParticipante();
                case 3 -> controller.crearInscripcion();
                case 4 -> controller.desinscribir();
                case 5 -> controller.mostrarMontos();
                default -> controller.mostrarOpcionIncorrecta();
            }

        } while (opcion != 0);

    }
}

