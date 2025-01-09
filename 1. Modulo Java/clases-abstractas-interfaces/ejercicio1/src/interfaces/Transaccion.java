package interfaces;

public interface Transaccion {

    public abstract void transaccionOk(String transaccion);

    public abstract void transaccionNoOk(String transaccion);

}
