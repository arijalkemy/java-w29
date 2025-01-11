package com.thiagoschreck.local.ejnumerosromanos.service;

import com.thiagoschreck.local.ejnumerosromanos.dto.NumeroRomanoDTO;
import com.thiagoschreck.local.ejnumerosromanos.model.NumeroRomano;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NumerosRomanosService {
    private enum Romano {
        I(1, 'I'),
        V(5, 'V'),
        X(10, 'X'),
        L(50, 'L'),
        C(100, 'C'),
        D(500, 'D'),
        M(1000, 'M'),
        // por si reviven los Romanos
        //A(5000, 'A'),
        //B(10000, 'B'),
        //Q(50000, 'Q'),
        //W(100000, 'W'),
        //Y(500000, 'Y'),
        //Z(1000000, 'Z'),
        ;

        private final Integer valorEntero;
        private final char valorRomano;
        public static final List<Romano> NUMEROS_ROMANOS_DESCENDIENTES = Arrays.stream(Romano.values()).sorted(Comparator.comparing(r -> -r.valorEntero)).toList();
        public static final int VALOR_MAXIMO_PERMITIDO = calcularLimite();

        Romano(int valorEntero, Character valorRomano) {
            this.valorEntero = valorEntero;
            this.valorRomano = valorRomano;
        }

        public Integer getValorEntero() {
            return valorEntero;
        }

        public Character getValorRomano() {
            return valorRomano;
        }

        private static int calcularLimite() {
            final Romano maximoNumeroRomano = NUMEROS_ROMANOS_DESCENDIENTES.getFirst();
            if (String.valueOf(maximoNumeroRomano.getValorEntero()).charAt(0) == '1') {
                return maximoNumeroRomano.getValorEntero() * 4 - 1;
            }
            final Romano segundoMaximoNumeroRomano = NUMEROS_ROMANOS_DESCENDIENTES.get(1);
            return maximoNumeroRomano.getValorEntero() + segundoMaximoNumeroRomano.getValorEntero() * 4 - 1;
        }
    }

    public NumeroRomanoDTO convertirANumeroRomano(int entero) {
        if (entero > Romano.VALOR_MAXIMO_PERMITIDO) {
            return new NumeroRomanoDTO(
                    new NumeroRomano(String.format("El número no puede ser mayor a %s", Romano.VALOR_MAXIMO_PERMITIDO), null),
                    entero
            );
        }
        if (entero <= 0) {
            return new NumeroRomanoDTO(
                    new NumeroRomano("El número no puede ser menor a 0", null),
                    entero);
        }
        return new NumeroRomanoDTO(convertir(entero), entero);
    }

    public NumeroRomanoDTO convertirANumeroEntero(String numeroRomano) {
        return new NumeroRomanoDTO(new NumeroRomano(numeroRomano, null), convertir(numeroRomano));
    }

    private static int convertir(String numeroRomano) {
        int valorEntero = 0;
        String[] cadenaDescompuesta = numeroRomano.split("");
        for (int i = 0; i < cadenaDescompuesta.length; i++) {
            final Romano romanoActual = Romano.valueOf(cadenaDescompuesta[i]);
            if (i < cadenaDescompuesta.length - 1) {
                final Romano romanoSiguiente = Romano.valueOf(cadenaDescompuesta[i + 1]);
                if (i < cadenaDescompuesta.length - 2) {
                    final Romano romanoSiguienteSiguiente = Romano.valueOf(cadenaDescompuesta[i + 2]);
                    if (romanoActual.getValorEntero() < romanoSiguienteSiguiente.getValorEntero()) {
                        valorEntero -= romanoActual.getValorEntero();
                    }
                    if (romanoActual.getValorEntero() < romanoSiguiente.getValorEntero()) {
                        valorEntero -= romanoActual.getValorEntero();
                        continue;
                    }
                }

                if (romanoActual.getValorEntero() < romanoSiguiente.getValorEntero()) {
                    valorEntero -= romanoActual.getValorEntero();
                    continue;
                }
            }
            valorEntero += romanoActual.getValorEntero();
        }
        return valorEntero;
    }

    private NumeroRomano convertir(int valorEntero) {
        final Integer[] enterosDescompuestos = obtenerEnterosDescompuestos(valorEntero);
        final String[] resultado = new String[enterosDescompuestos.length];

        for (int idxEnteros = 0; idxEnteros < enterosDescompuestos.length; idxEnteros++) {
            final int enteroActual = enterosDescompuestos[idxEnteros];
            if (enteroActual == 0) {
                continue;
            }

            for (int idxRomanos = 0; idxRomanos < Romano.NUMEROS_ROMANOS_DESCENDIENTES.size(); idxRomanos++) {
                final Romano romanoActual = Romano.NUMEROS_ROMANOS_DESCENDIENTES.get(idxRomanos);
                final int valorEnteroRomano = romanoActual.getValorEntero();

                // region CASO: Número exacto (ej: 1, 5, 10, 50, etc.)
                if (enteroActual == valorEnteroRomano) {
                    resultado[idxEnteros] = String.valueOf(romanoActual.getValorRomano());
                    break;
                }
                // endregion

                // region CASO: Número exacto repetido, distinto a variantes de 5 (ej: II, XX, III, XXX, etc.)
                if (romanoActual.getValorEntero().toString().charAt(0) == '1') {
                    int cociente = enteroActual / valorEnteroRomano;
                    if (cociente == 2 || cociente == 3) {
                        resultado[idxEnteros] = romanoActual.getValorRomano().toString().repeat(cociente);
                        break;
                    }
                }
                // endregion

                final int diferencia = enteroActual - valorEnteroRomano;
                final Romano romanoInferior = getRomanoInferiorVarianteDe1(romanoActual, idxRomanos);

                // region CASO: Número menor a número exacto por 1 (ej: 4, 9, 49, 99, etc.)
                if (diferencia == -1 * romanoInferior.getValorEntero()) {
                    resultado[idxEnteros] = romanoInferior.getValorRomano().toString()
                            .concat(romanoActual.getValorRomano().toString());
                    break;
                }
                // endregion

                // region CASO: Número mayor a número exacto por <= 3 en variantes de 5 (ej: 6, 7, 8, 16, 17, 18, etc.)
                final int cociente = diferencia / romanoInferior.getValorEntero();
                if (!esVarianteDe1(romanoActual) && diferencia > 0 && cociente <= 3) {
                    resultado[idxEnteros] = romanoActual.getValorRomano().toString()
                            .concat(romanoInferior.getValorRomano().toString().repeat(Math.max(0, cociente)));
                    break;
                }
                // endregion
            }
        }
        return new NumeroRomano(Arrays.stream(resultado).filter(Objects::nonNull).collect(Collectors.joining()), resultado);
    }

    private Romano getRomanoInferiorVarianteDe1(Romano romanoActual, int idxActual) {
        if (romanoActual.equals(Romano.NUMEROS_ROMANOS_DESCENDIENTES.getLast())) {
            return Romano.NUMEROS_ROMANOS_DESCENDIENTES.getLast();
        }
        if (esVarianteDe1(romanoActual)) {
            return Romano.NUMEROS_ROMANOS_DESCENDIENTES.get(idxActual + 2);
        }
        return Romano.NUMEROS_ROMANOS_DESCENDIENTES.get(idxActual + 1);
    }

    private boolean esVarianteDe1(Romano romano) {
        return String.valueOf(romano.getValorEntero()).charAt(0) == '1';
    }

    private Integer[] obtenerEnterosDescompuestos(int valorEntero) {
        final Integer[] enteroDescompuesto = Arrays.stream(String.valueOf(valorEntero).split(""))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        for (int i = 0; i < enteroDescompuesto.length; i++) {
            enteroDescompuesto[i] *= (int) Math.pow(10, enteroDescompuesto.length - i - 1);
        }
        return enteroDescompuesto;
    }
}
