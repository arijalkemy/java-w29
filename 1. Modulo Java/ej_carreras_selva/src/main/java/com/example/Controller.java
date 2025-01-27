package com.example;

import java.util.*;

public class Controller {

    private final Scanner scanner = new Scanner(System.in);

    private final List<Map<String, String>> categorias = List.of(
            Map.of("nombre","Circuito chico", "descripcion", "2 km por selva y arroyos"),
            Map.of("nombre", "Circuito medio", "descripcion", "5 km por selva, arroyos y barro"),
            Map.of("nombre", "Circuito avanzado", "descripcion", "10km por selva, arroyos, barro y escalada en piedra")
    );

    // Key -> DNI
    private final Map<Integer, Map<String, String>> participantes = new HashMap<>();

    // Key -> DNI
    private final Map<Integer, Map<String, Integer>> inscripciones = new HashMap<>();

    // Colores para los mensjaes
    private final String div = "-----------------------------";
    private final String RESET = "\u001B[0m";
    private final String ROJO = "\u001B[31m";
    private final String VERDE = "\u001B[32m";
    private final String AMARILLO = "\u001B[33m";
    private final String AZUL = "\u001B[34m";

    public Integer mostrarMenu() {
        System.out.println(AZUL + "\nMenú de opciones");
        System.out.println(div);
        System.out.println("1. Mostrar inscripciones");
        System.out.println("2. Crear participante");
        System.out.println("3. Crear inscripción");
        System.out.println("4. Desinscribir");
        System.out.println("5. Mostrar montos");
        System.out.println("0. Salir");
        System.out.println(div + RESET);
        return pedirEntero("Opción");
    }

    public void mostrarOpcionIncorrecta() {
        System.out.println(ROJO + "Opción incorrecta" + RESET);
    }

    public int pedirEntero(String mensaje) {
        int num;
        while (true) {
            System.out.print(mensaje + ": ");
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine();
                break;
            }
            System.out.println(ROJO + "Debe ingresar un número entero" + RESET);
            scanner.next();
        }
        return num;
    }

    // Devuelve el nombre de la categoría dado el id
    private String getCategoriaStr(int index) {
        return categorias.get(index).get("nombre");
    }

    // Mostrar inscripciones de una categoría
    public void mostrarInscripciones(int categoria) {
        System.out.printf(AMARILLO + "\n%s\n", getCategoriaStr(categoria));

        // Verificar que haya inscripciones
        if (inscripciones.size() == 0) {
            System.out.println(ROJO + "No hay inscripciones para esta categoría" + RESET);
            return;
        }

        // Tabla
        System.out.println(div);
        System.out.printf("%-15s %-15s %n", "Participante", "Monto");
        System.out.println(div);

        for (Map.Entry<Integer, Map<String, Integer>> inscripcion : inscripciones.entrySet()) {
            if (inscripcion.getValue().get("categoria") != categoria) {
                continue;
            }
            int dniParticipante = inscripcion.getKey();
            System.out.printf("%-15s $%-15s %n",
                    participantes.get(dniParticipante).get("nombre"),
                    inscripcion.getValue().get("monto")
            );
        }

        System.out.println(div + RESET);
    }

    public void crearParticipante() {
        Map<String, String> datos = new HashMap<>();

        int dni = obtenerDniValido();
        datos.put("dni", Integer.toString(dni));

        datos.put("numero de participante", Integer.toString(participantes.size()));

        System.out.print("Ingrese el nombre: ");
        datos.put("nombre", scanner.nextLine());

        System.out.print("Ingrese el apellido: ");
        datos.put("apellido", scanner.nextLine());

        int edad = pedirEntero("Ingrese la edad");
        datos.put("edad", Integer.toString(edad));

        System.out.print("Ingrese el celular: ");
        datos.put("celular", scanner.nextLine());

        System.out.print("Ingrese un número de emergencia: ");
        datos.put("numero de emergencia", scanner.nextLine());

        System.out.print("Ingrese el grupo sanguíneo: ");
        datos.put("grupo sanguineo", scanner.nextLine());

        participantes.put(dni, datos);
        System.out.println(VERDE + "\n¡Participante creado exitosamente!" +  RESET);
    }

    private int obtenerDniValido() {
        int dni;
        while (true) {
            dni = pedirEntero("Ingrese el dni");
            if (!participantes.containsKey(dni)) {
                break;
            }
            System.out.println(ROJO + "El participante con el DNI ingresado ya está registrado" + RESET);
        }
        return dni;
    }

    public void crearInscripcion() {
        int dni = pedirEntero("Ingrese el dni");

        if (!participantes.containsKey(dni)) {
            System.out.println(ROJO + "No se ha encontrado al participante" + RESET);
            return;
        }

        if (inscripciones.containsKey(dni)) {
            System.out.println(ROJO + "Ya está inscripto este participante" + RESET);
        }

        int categoria;

        while (true) {
            categoria = pedirEntero("Ingrese una categoría");
            if (1 <= categoria && categoria <= categorias.size()) break;
            System.out.println(ROJO + "Categoría no encontrada" + RESET);
        }

        int monto = calcularMonto(dni, categoria);
        if (monto == -1) return;

        inscripciones.put(dni, Map.of(
                "categoria", categoria - 1,
                "monto", monto
        ));

        System.out.println(VERDE + "\n¡Inscripción creada exitosamente!" +  RESET);
    }

    private int calcularMonto(int dni, int categoria) {
        int edad = Integer.parseInt(participantes.get(dni).get("edad"));
        boolean esMayor = edad >= 18;
        int monto = -1;

        switch (categoria) {
            case 1 -> monto = esMayor ? 1500 : 1300;
            case 2 -> monto = esMayor ? 2300 : 2000;
            case 3 -> monto = esMayor ? 2800 : -1;
        }

        if (monto == -1) {
            System.out.println(ROJO + "No se ha podido inscribir porque es menor de edad" + RESET);
        }
        return monto;
    }

    public void desinscribir() {
        System.out.print("\nIngrese el DNI del participante a desinscribir: ");
        int dni = Integer.parseInt(scanner.nextLine());

        if (!participantes.containsKey(dni)) {
            System.out.println(ROJO + "No se ha encontrado al participante" + RESET);
            return;
        }

        if (!inscripciones.containsKey(dni)) {
            System.out.println(ROJO + "No está inscripto este participante" + RESET);
        }

        Map<String, Integer> inscripcionEliminada = inscripciones.remove(dni);

        System.out.println(VERDE + "¡Inscripción eliminada exitosamente!" + RESET);

        int idCategoria = inscripcionEliminada.get("categoria");
        mostrarInscripciones(idCategoria);
    }

    public void mostrarMontos() {
        int[] montos = new int[categorias.size()];
        int montoTotal = 0;

        for (Map.Entry<Integer, Map<String, Integer>> inscripcion : inscripciones.entrySet()) {
            int categoria = inscripcion.getValue().get("categoria");
            int monto = inscripcion.getValue().get("monto");

            montos[categoria] += monto;
        }

        System.out.println(AMARILLO + "\nMontos por categoría");
        System.out.println(div);

        for (int i = 0; i < categorias.size(); i++) {
            int monto = montos[i];
            System.out.printf("%-20s $%-10d %n", getCategoriaStr(i), monto);
            montoTotal += monto;
        }

        System.out.println(div);
        System.out.printf("%-20s $%-10d %n", "Monto total", montoTotal);
        System.out.println(div + RESET);
    }

}