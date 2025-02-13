
Programación Java

 Tests unitarios y de integración
// Práctica individual



Objetivo

El objetivo de esta guía práctica es que podamos afianzar y practicar la implementación de tests en aplicaciones spring boot. Para esto se tomará como base el proyecto “Calculadora de metros cuadrados”. Se deberán realizar las pruebas unitarias y de Integración del mismo.


¿Are you ready? 



















Descripción


La API presentada recibe los datos de una Propiedad Inmobiliaria con su “nombre”, “dirección” y sus “habitaciones”. Cada una de las habitaciones, al mismo tiempo, contienen un “nombre”, un “ancho” y un “largo”. Estos son los datos de entrada.




Ejercicio 1


Se solicita verificar la funcionalidad de la aplicación y crear los test unitarios correspondientes para las capas de controladores y servicios. Agregar los escenarios necesarios para obtener la mayor cobertura de código posible, comprobando que el comportamiento esperado de cada unidad se cumpla correctamente. Se deben identificar las dependencias de cada clase y mockearlas en caso de ser necesario para poder testearlas unitariamente.


A continuación se indican algunos escenarios sugeridos:


Escenario de entrada

Comportamiento esperado

Verificar el cálculo del valor de la propiedad

Devuelve el cálculo correcto del valor de la propiedad basado en la cantidad de metros cuadrados

Verificar que la habitación con las mayores dimensiones sea considerada la más grande

Retornar los datos de la habitación más grande basado en las propiedades “width” y “height”

Verificar la cantidad de metros cuadrados por habitación

Devolver la cantidad correcta de metros cuadrados por habitación



Ejercicio 2

Se requiere crear los tests de integración necesarios para cubrir el comportamiento de la capa de los controladores. Tener en cuenta la mayor cantidad de escenarios posibles.



 Ejercicio 3

Luego de finalizados los ejercicios (y prácticas) anteriores verificar que se haya obtenido una cobertura de código (code coverage) del 80% como mínimo. De no alcanzarse ese nivel, revisar tanto los Tests de Unidad (con y sin Mocks) como los Tests de Integración hasta que se logre el estándar requerido.


