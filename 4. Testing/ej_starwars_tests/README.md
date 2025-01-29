# Star wars

## Descripción

Recapitulamos sobre la funcionalidad aplicada en el proyecto “StarWars”:

Se trata de una API que permite buscar por nombre o parte del mismo personajes de Star Wars. La misma recibe una palabra a buscar y retorna un listado de personajes que contengan esa palabra en su nombre.

Ejemplo:

- Si buscamos "Luke" → nos mostrará el personaje de "Luke Skywalker".
- Si buscamos "Darth" → nos mostrará el personaje de "Darth Vader" y "Darth Maul".

Esta aplicación utiliza el archivo starwars.json como base de datos.

## Ejercicio 1

Se solicita crear los test unitarios correspondientes para las capas de controladores, servicios y repositorios. Agregar los escenarios necesarios para obtener la mayor cobertura de código posible, comprobando que el comportamiento esperado de cada unidad se cumpla correctamente.

Las clases candidatas para ser testeadas unitariamente son las siguientes:

- FindController
- CharacterRepositoryImpl
- FindService

1) El mínimo de cobertura esperada por cada una de las clases nombradas es del 80%.

2) Se deben identificar las dependencias de cada clase y mockearlas en caso de ser necesario para poder testearlas unitariamente.

## Ejercicio 2

Se requiere crear los tests de integración necesarios para cubrir el comportamiento de la capa de controladores FindController. Tener en cuenta la mayor cantidad de escenarios posibles.

## Ejercicio 3

Luego de implementar los tests, verificar que se haya obtenido una cobertura de código (code coverage) del 80% como mínimo. De no alcanzarse ese nivel, revisar tanto los Tests Unitarios como los Tests de Integración hasta que se logre el estándar requerido.