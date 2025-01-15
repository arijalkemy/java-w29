package org.example.model;

class DescuentoPorLocalizadores implements Descuentos {

    @Override
    public void aplicar(Localizador localizador) {
        Cliente cliente = localizador.getCliente();
        if (cliente.getLocalizadores().size() >= 2) {
            localizador.aplicarDescuento(5);
        }
    }

}
