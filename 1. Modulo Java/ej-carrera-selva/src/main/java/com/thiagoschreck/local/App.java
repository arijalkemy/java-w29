package com.thiagoschreck.local;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        carrera.run();
    }
}

class Carrera {
    private static final Categoria CIRCUITO_CHICO = new Categoria(1300, 1500);
    private static final Categoria CIRCUITO_MEDIO = new Categoria(2000, 2300);
    private static final Categoria CIRCUITO_AVANZADO = new Categoria(2800);
    public static final String TEXTO_LISTA_CIRCUITOS = "Categorías:\n1 - Circuito chico\n2 - Circuito mediano\n3 - Circuito avanzado";

    private final Map<String, Participante> inscripciones = new HashMap<>();

    public void run() {
        inicializarDatos();
        iniciarMenu();
    }

    private void inicializarDatos() {
        inscripciones.put("1234", new Participante("1234", "1.234.567-8", "Thiago", "Schreck", 23, "+1 234 567 89", "911", "A", CIRCUITO_CHICO));
        inscripciones.put("1235", new Participante("1235", "1.234.567-9", "Johnny", "Test", 15, "+1 234 567 89", "911", "A", CIRCUITO_CHICO));
        inscripciones.put("1236", new Participante("1236", "1.234.567-0", "Hola", "Adios", 21, "+1 234 567 89", "911", "A", CIRCUITO_MEDIO));
        inscripciones.put("1237", new Participante("1237", "1.234.567-1", "Fulano", "Detal", 20, "+1 234 567 89", "911", "A", CIRCUITO_AVANZADO));
    }

    private void iniciarMenu() {
        while (true) {
            System.out.print("""
                    Elija una opción:
                    1- Inscribir un nuevo participante
                    2- Eliminar un participante
                    3- Consultar costo para un participante
                    4- Listar participantes
                    5- Consultar ganancias
                    0- Salir
                   \s
                    Opción:\s""");
            Scanner scanner = new Scanner(System.in);
            String opcion = scanner.next();

            switch (opcion) {
                case "1" -> inscribir();
                case "2" -> eliminar();
                case "3" -> consultarCosto();
                case "4" -> listar();
                case "5" -> consultarGanancias();
                case "0" -> {
                    return;
                }
            }
        }
    }

    private void inscribir() {
        Participante participante = new Participante();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Edad: ");
        participante.setEdad(scanner.next());
        System.out.println(TEXTO_LISTA_CIRCUITOS);
        int categoria = -1;
        while (categoria == -1) {
            System.out.print("N° Categoria: ");
            String input = scanner.next();
            if (List.of("1", "2", "3").contains(input)) {
                categoria = Integer.parseInt(input);
            }
        }
        Categoria circuito = categoria == 1 ? CIRCUITO_CHICO : categoria == 2 ? CIRCUITO_MEDIO : CIRCUITO_AVANZADO;
        if (CIRCUITO_AVANZADO.equals(circuito) && participante.getEdad() < 18) {
            System.out.println("ERROR: El circuito avanzado es solo apto para mayores de 18 años!");
            return;
        }
        participante.setCategoria(circuito);
        System.out.print("Número de participante: ");
        participante.setNumero(scanner.next());
        if (inscripciones.containsKey(participante.getNumero())) {
            System.out.println("Ya existe un participante con ese número.");
            return;
        }
        System.out.print("DNI: ");
        participante.setDni(scanner.next());
        System.out.print("Nombre: ");
        participante.setNombre(scanner.next());
        System.out.print("Apellido: ");
        participante.setApellido(scanner.next());
        System.out.print("Celular: ");
        participante.setCelular(scanner.next());
        System.out.print("Número de emergencia: ");
        participante.setNumeroEmergencia(scanner.next());
        System.out.print("Grupo sanguíneo: ");
        participante.setGrupoSanguineo(scanner.next());

        inscripciones.put(participante.getNumero(), participante);
        imprimirCosto(participante);
    }

    private void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número de participante: ");
        String numero = scanner.next();
        Participante participante = inscripciones.remove(numero);
        if (participante == null) {
            System.out.println("El participante no existe");
            return;
        }
        System.out.printf("Se eliminó el participante N°%s%n", participante.getNumero());
        imprimirLista(participante.getCategoria());
    }

    private void consultarCosto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Número de participante: ");
        String numero = scanner.next();
        Participante participante = inscripciones.get(numero);
        if (participante == null) {
            System.out.println("El participante no existe");
            return;
        }
        imprimirCosto(participante);
    }

    private void listar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(TEXTO_LISTA_CIRCUITOS);
        int categoria = -1;
        while (categoria == -1) {
            System.out.print("N° Categoria: ");
            String input = scanner.next();
            if (List.of("1", "2", "3").contains(input)) {
                categoria = Integer.parseInt(input);
            }
        }
        Categoria circuito = categoria == 1 ? CIRCUITO_CHICO : categoria == 2 ? CIRCUITO_MEDIO : CIRCUITO_AVANZADO;
        imprimirLista(circuito);
    }

    private void consultarGanancias() {
        System.out.println("\nLas ganancias son las siguientes:\n");
        int gananciasChico = consultarGanancias(CIRCUITO_CHICO);
        int gananciasMedio = consultarGanancias(CIRCUITO_MEDIO);
        int gananciasAvanzado = consultarGanancias(CIRCUITO_AVANZADO);
        System.out.printf("Circuito chico: $%s%n", gananciasChico);
        System.out.printf("Circuito medio: $%s%n", gananciasMedio);
        System.out.printf("Circuito avanzado: $%s%n", gananciasAvanzado);
        System.out.printf("%nTotal: $%s%n%n", gananciasChico + gananciasMedio + gananciasAvanzado);
    }

    private int consultarGanancias(Categoria categoria) {
        return getParticipantes(categoria)
                .map(Participante::calcularCosto)
                .reduce(0, Integer::sum);
    }

    private void imprimirLista(Categoria categoria) {
        System.out.println("\nLos participantes son los siguientes:");
        getParticipantes(categoria).forEach(System.out::println);
    }

    private Stream<Participante> getParticipantes(Categoria categoria) {
        return inscripciones.values().stream().filter(participante -> categoria.equals(participante.getCategoria()));
    }
    private void imprimirCosto(Participante participante) {
        System.out.printf("El costo de la carrera para el participante N° %s es de $%s.%n%n", participante.getNumero(), participante.calcularCosto());
    }
}

class Categoria {
    private final boolean permiteMenores;
    private final int precioMenores;
    private final int precioMayores;

    public Categoria(int precioMayores) {
        this.permiteMenores = false;
        this.precioMenores = -1;
        this.precioMayores = precioMayores;
    }

    public Categoria(int precioMenores, int precioMayores) {
        this.permiteMenores = true;
        this.precioMenores = precioMenores;
        this.precioMayores = precioMayores;
    }

    public boolean permiteMenores() {
        return permiteMenores;
    }

    public int getPrecioMenores() {
        return precioMenores;
    }

    public int getPrecioMayores() {
        return precioMayores;
    }
}

class Participante {
    private String numero;
    private String dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;
    private Categoria categoria;

    public Participante() {
    }

    public Participante(String numero, String dni, String nombre, String apellido, int edad, String celular, String numeroEmergencia, String grupoSanguineo, Categoria categoria) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = categoria;
    }

    public String getNumero() {
        return numero;
    }

    public int getEdad() {
        return edad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int calcularCosto() {
        if (categoria == null) {
            return 0;
        }
        if (edad < 18 && categoria.permiteMenores()) {
            return categoria.getPrecioMenores();
        }
        if (edad > 18) {
            return categoria.getPrecioMayores();
        }
        return 0;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(String edad) {
        this.edad = Integer.parseInt(edad);
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("#%s - %s %s - %s años - DNI %s%n Celular: %s - Emergencia: %s - Grupo sanguíneo: %s",
                numero, nombre, apellido, edad, dni, celular, numeroEmergencia, grupoSanguineo);
    }
}

