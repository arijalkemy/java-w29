package com.integrador.saveropa;


import java.util.List;

public class SaveRopaApplication {

	public static void main(String[] args) {
		Prenda prenda1 = new Prenda("marca1", "modelo1");
		Prenda prenda2 = new Prenda("marca2", "modelo2");

		Guardarropa guardaRopa = new Guardarropa();
		Integer codigo = guardaRopa.guardarPrendas(List.of(prenda1, prenda2));

		System.out.println("Codigo: " + codigo);
		guardaRopa.devolverPrendas(codigo).forEach(System.out::println);

		guardaRopa.guardarPrendas(List.of(prenda1, prenda2));

		guardaRopa.mostrarPrendas();
	}

}
