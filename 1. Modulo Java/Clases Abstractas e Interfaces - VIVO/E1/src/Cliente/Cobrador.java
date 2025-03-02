package Cliente;

import Transaccion.ConsultaSaldo;
import Transaccion.RetiroEfectivo;

public class Cobrador {
    public void realizarRetiroEfectivo() {
        new RetiroEfectivo().transaccionOk();
    }

    public void realizarConsultaSaldo(){
        new ConsultaSaldo().transaccionOk();
    }
}
