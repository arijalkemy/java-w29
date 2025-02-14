
-- Ejercicio 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE twd (
SELECT e.*
FROM episodes e  
JOIN seasons  ON e.season_id  = seasons.id
JOIN series ON series.id = seasons.serie_id
WHERE series.title LIKE '%the walking dead%'
);

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM twd
JOIN seasons ON twd.season_id = seasons.id
WHERE seasons.title LIKE '%primer temporada%'


-- Ejercicio 2

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

CREATE INDEX movies_title_IDX ON movies_db.movies (title);
SHOW INDEX FROM movies;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
		-- se escoge title por que es un campo donde se pueden realizar filtros continuamente, ademas se puede decir que todos los valores de este campo son unicos 



