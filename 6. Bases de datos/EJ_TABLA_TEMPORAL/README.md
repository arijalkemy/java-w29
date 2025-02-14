# Creación de Tablas Temporales e Índices

## Ejercicio 1

1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

```sql
-- Crear tabla TWD
CREATE TEMPORARY TABLE TWD (
    id INT,
    title VARCHAR(50),
    number_episode INT,
    number_season INT
);
       
-- Insertar datos en  TWD
INSERT INTO TWD
SELECT e.id     AS episode_id,
       e.title  AS episode_title,
       e.number AS episode_number,
       s.number AS season_number
FROM episodes e
         JOIN seasons s ON e.season_id = s.id
         JOIN series ser ON S.serie_id = ser.id
WHERE ser.title = 'The Walking Dead';
```
2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
```sql
-- Comprobar datos en tabla WTD
SELECT *
FROM TWD;
```
## Ejercicio 2
1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
```sql
-- crear indice en titulo de la tabla series
CREATE INDEX index_title ON series(title);
```
2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

RTA: Se puede tomar como una llave unica el título de las series, ya que es unico y esto facilitara las búsquedas de las consultas.

## Solución
[solucion](tablaTemporal.sql)