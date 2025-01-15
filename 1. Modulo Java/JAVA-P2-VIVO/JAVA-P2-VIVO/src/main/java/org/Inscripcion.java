package org;

class Inscripcion {
    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = calcularMonto();
    }

    private int calcularMonto() {
        int edad = participante.getEdad();
        if (categoria.getNombre().equals("Circuito chico")) {
            return edad < 18 ? 1300 : 1500;
        } else if (categoria.getNombre().equals("Circuito medio")) {
            return edad < 18 ? 2000 : 2300;
        } else if (categoria.getNombre().equals("Circuito avanzado")) {
            return edad < 18 ? 0 : 2800;
        }
        return 0;
    }

    public int getMonto() {
        return monto;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria='" + categoria.getNombre() + '\'' +
                ", participante=" + participante +
                ", monto=$" + monto +
                '}';
    }
}