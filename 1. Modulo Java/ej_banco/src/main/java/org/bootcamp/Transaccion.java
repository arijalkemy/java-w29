package org.bootcamp;

public interface Transaccion {

    void transaccionOk(String transaccion);
    void transaccionNoOk(String transaccion);
}
