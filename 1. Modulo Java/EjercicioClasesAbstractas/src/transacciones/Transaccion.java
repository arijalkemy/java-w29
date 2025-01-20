package transacciones;

import java.util.Random;

public abstract class Transaccion {

    public Transaccion() {}
    public void transaccionOk(){
        System.out.println("Transaccion OK");
    }
    public void transaccionNotOk(){
        System.out.println("Transaccion no Ok");
    }

    public abstract void doTransaction();

    public void estadoTransaccion(){
        Integer randomInt = new Random().nextInt(2);
        if (randomInt.equals(1)){
            transaccionOk();
        } else if (randomInt.equals(0)){
            transaccionNotOk();
        }
    }
}
