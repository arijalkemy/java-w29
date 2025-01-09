# Programación Java: DAKAR
## Práctica integradora

Hacer punto por punto ordenadamente, sin saltear.

Realizar los diagramas de clase correspondientes en cada paso y aplicar los cambios a medida que vamos resolviendo los distintos puntos.

1. Crear la clase `Vehículo` que tenga los siguientes atributos:
    - **Velocidad**
    - **Aceleración**
    - **Ángulo de giro**
    - **Patente**
    - **Peso**
    - **Ruedas**

---

2. Modelar la clase `Carrera` que tiene los siguientes atributos:
    - **Distancia**
    - **PremioEnDolares**
    - **Nombre**
    - **CantidadDeVehículosPermitidos**
    - **ListaDeVehículos**

---

3. Se quiere agregar dos nuevas categorías de vehículos:
    - **Autos**
 
    - **Motos**

Los autos pesan 1.000 kilos y las motos 300 kilos, los autos tienen 4 ruedas y las motos 2.
       

---

4. Una carrera además tiene un conjunto de vehículos que participarán de la misma. Entonces, ahora la carrera va a tener la responsabilidad de poder agregar a un vehículo. Por lo tanto, debemos definir los siguientes métodos:  
   `public void darDeAltaAuto(velocidad, aceleracion, AnguloDeGiro, patente);`  
   `public void darDeAltaMoto(velocidad, aceleracion, AnguloDeGiro, patente);`

   Ambos métodos agregan un vehículo siempre y cuando haya cupo.

---

5. También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:  
   `public void eliminarVehiculo(Vehículo vehículo);`  
   `public void eliminarVehiculoConPatente(String unaPatente);`

---

6. Queremos poder definir el ganador de una carrera:  
   El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:  
   `Velocidad * ½ Aceleración / (ÁnguloDeGiro * (Peso - Cantidad de Ruedas * 100))`

---

7. Las carreras también cuentan con vehículos socorristas que ante alguna emergencia van y reparan a un vehículo. Como los autos son muy diferentes a las motos, existen dos clases distintas de vehículos socorristas. Uno de estos solo sabe socorrer autos y otro solo sabe socorrer motos.

   a. **Agregar las clases:**
    - `SocorristaAuto`
    - `SocorristaMoto`

   b. **Agregar los métodos:**
    - `SocorristaAuto → public void socorrer(Auto unAuto);`
    - `SocorristaMoto → public void socorrer(Moto unaMoto);`

   Cuando un socorrista se acerca a un auto, imprime por pantalla:  
   `"Socorriendo auto"` y el número de patente.  
   Cuando socorre a una moto, imprime por pantalla:  
   `"Socorriendo moto"` y el número de patente.

   a. **Agregar a la clase carrera un socorrista de autos y uno de motos.

   b. **Agregar a la clase carrera la responsabilidad de socorrer una moto y un auto:**
    - `public void socorrerAuto(String patente);`
    - `public void socorrerMoto(String patente);`
