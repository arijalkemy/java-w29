package org.example.clientes;

import org.example.tipos.Consulta;
import org.example.tipos.PagosServicio;
import org.example.tipos.Retiro;

public class Basico extends Cliente {

    @Override
    public void consulta(){
        new Consulta().transaccionCorrecta();
    }
    @Override
    public void pagosServicio(){
        new PagosServicio().transaccionCorrecta();
    }
    @Override
    public void retiro(){
        new Retiro().transaccionCorrecta();
    }

}
