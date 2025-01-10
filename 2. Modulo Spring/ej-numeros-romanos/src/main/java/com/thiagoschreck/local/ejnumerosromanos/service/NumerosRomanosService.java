package com.thiagoschreck.local.ejnumerosromanos.service;

import com.thiagoschreck.local.ejnumerosromanos.dto.NumeroRomanoDTO;
import com.thiagoschreck.local.ejnumerosromanos.dto.NumeroRomanoDTO.NumeroRomano;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NumerosRomanosService {
    private enum Romano {
        I(1, 'I'),
        V(5, 'V'),
        X(10, 'X'),
        L(50, 'L'),
        C(100, 'C'),
        D(500, 'D'),
        M(1000, 'M');

        private final Integer valorDecimal;
        private final char valorRomano;
        public static final List<Romano> NUMEROS_ROMANOS_DESCENDIENTES = List.of(Romano.M, Romano.D, Romano.C, Romano.L, Romano.X, Romano.V, Romano.I);

        Romano(int valorDecimal, Character valorRomano) {
            this.valorDecimal = valorDecimal;
            this.valorRomano = valorRomano;
        }

        public int getValorEntero() {
            return valorDecimal;
        }

        public Character getValorRomano() {
            return valorRomano;
        }
    }

    public NumeroRomanoDTO getNumeroRomanoDTO(String entero) {
        int valorEntero = Integer.parseInt(entero);
        if (valorEntero > 3999) {
            return new NumeroRomanoDTO(
                    new NumeroRomano("El número no puede ser mayor a 3999", null),
                    valorEntero
            );
        }
        if (valorEntero <= 0) {
            return new NumeroRomanoDTO(
                    new NumeroRomano("El número no puede ser menor a 0", null),
                    valorEntero);
        }
        return new NumeroRomanoDTO(convertir(valorEntero), valorEntero);
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
                if (romanoActual.valorDecimal.toString().charAt(0) == '1') {
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
                            .concat(String.valueOf(romanoInferior.getValorRomano()).repeat(Math.max(0, cociente)));
                    break;
                }
                // endregion
            }
        }
        return new NumeroRomano(String.join("", resultado), resultado);
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
