package org.example.clientes;

import org.example.tipos.Consulta;
import org.example.tipos.Retiro;

public class Colaborador extends Cliente {
    @Override
    public void retiro(){
        new Retiro().transaccionCorrecta();
    }
    @Override
    public void consulta(){
        new Consulta().transaccionCorrecta();
    }
}
