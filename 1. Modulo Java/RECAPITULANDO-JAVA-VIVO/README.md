# Proyecto de Gestión de Vehículos

Este proyecto consiste en la implementación de un sistema de gestión de vehículos, que incluye clases para representar vehículos y un garaje. A continuación se describen los ejercicios realizados.

## Ejercicio 1: Creación de Clases

- **Clase `Vehículo`**:
    - Atributos: `modelo`, `marca` y `costo`.
    - Métodos: Constructores, getters y setters.

- **Clase `Garaje`**:
    - Atributos: `id` (identificador único) y `listaVehiculos` (una lista de objetos de la clase `Vehículo`).
    - Métodos: Constructores, getters y setters.

## Ejercicio 2: Clase Main

Se crea una clase `Main` con el método `main` para representar un escenario en el que se crea una instancia de la clase `Garaje` con una lista de vehículos, de acuerdo a la siguiente tabla:

| Marca      | Modelo      | Precio |
|------------|-------------|--------|
| Ford       | Fiesta      | 1000   |
| Ford       | Focus       | 1200   |
| Ford       | Explorer    | 2500   |
| Fiat       | Uno         | 500    |
| Fiat       | Cronos      | 1000   |

## Ejercicio 3: Ordenar Vehículos por Precio

Se utiliza el método `sort` en la lista de vehículos con expresiones lambda para obtener una lista de vehículos ordenados por precio de menor a mayor. Se imprime el resultado en la consola.

## Ejercicio 4: Ordenar Vehículos por Marca y Precio

De manera similar al ejercicio anterior, se imprime una lista ordenada primero por marca y luego por precio.

## Ejercicio 5: Filtrado y Cálculo

- Se extrae una lista de vehículos con precio no mayor a 1000.
- Se extrae otra lista con precios mayores o iguales a 1000.
- Se calcula y muestra el promedio total de precios de toda la lista de vehículos.
