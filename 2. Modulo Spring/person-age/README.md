# Person's age

## Ejercicio 1: Obteniendo la edad de una persona

Se necesita desarrollar un API que recibe como parámetro tres valores:
- Día
- Mes
- Año

Dichos valores corresponden a la fecha de nacimiento de una persona y deben ser valores enteros. Por ejemplo, un ingreso válido sería: 10/01/1990.

Para este caso, es necesario que la fecha de nacimiento se pase mediante la URL del navegador. Por ejemplo: http://localhost:8080/10/01/1990. Como resultado, la API deberá devolver la edad de la persona.

Realizar los pasos necesarios para implementar un método en el controlador que mapee correctamente el path ingresado y que devuelva la información requerida.

## Ejercicio 2: Creando una persona

Se debe hacer un POST a "/persona" y cargargla en memoria con su id, nombre y fecha de nacimiento.

## Ejercicio 3: Obteniendo la edad de una persona por id

Se debe hacer un GET a "/persona/{id}" y hay que devolver la edad de la persona.