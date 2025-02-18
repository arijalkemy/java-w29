# Ejercicio obras literarias

## 1. Carga de obras literarias

Crear una api que permita cargar obras literarias en una base de datos que implementa Elasticsearch.

De cada obra literaria se debe poder almacenar el id, el nombre, autor, cantidad de páginas, editorial y el año de su primera publicación.

Antes de pasar al punto siguiente, cargar 10 obras de ejemplo usando Postman.

## 2. Consultas sobre la API

Crear las endpoints que permitan realizar las siguientes consultas:

1. Retornar las obras de un determinado autor. Por ejemplo, todas las obras de “Garcia Marquez”
2. Retornar las obras que contengan palabras claves en sus títulos. Por ejemplo: que contengan la palabra “quijote”
3. Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
4. Retornar las obras que fueron publicadas antes de un determinado año. Por ejemplo: Antes de 1998.
5. Retornar todas las obras de una determinada editorial. Por ejemplo: Todas las obras de la editorial “Santillana”
