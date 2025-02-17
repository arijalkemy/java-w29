-- Ejercicio Tablas Temporales


-- Ejercicio 1:
-- 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD AS
SELECT e.id, e.title AS title_episode, s.`number` AS season_number, s2.title AS title_serie
FROM episodes e
INNER JOIN seasons s ON e.season_id = s.id
INNER JOIN series s2 ON s.serie_id = s2.id
WHERE s2.title = "The Walking Dead";

-- 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT *
	FROM TWD
	WHERE season_number = 1;


-- Ejercicio 2:
-- 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

CREATE INDEX release_date_idx ON episodes(release_date);

-- 2. Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- Se crearía el índice para permitir acceder a búsquedas más eficientes siempre que se quiera filtrar episodios por la fecha de publicación.