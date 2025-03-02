package Cliente;

import Transaccion.ConsultaSaldo;
import Transaccion.PagoServicio;
import Transaccion.RetiroEfectivo;

public class Basico {
    public void realizarConsultaSaldo(){
        new ConsultaSaldo().transaccionOk();
    }

    public void realizarPagoServicio(){
        new PagoServicio().transaccionOk();
    }

    public void realizarRetiroEfectivo() {
        new RetiroEfectivo().transaccionOk();
    }
}
