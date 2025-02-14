USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies (id, title, rating, awards, release_date, length) 
VALUES(22,'Interstellar', 4.0, 3, '2007-07-16 00:00:00', '120');

-- Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active) 
VALUES ('Comedia Romantica', 13, 1)

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 3
WHERE id = 22

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors 
SET favorite_movie_id = 22
WHERE last_name LIKE '%Depp%'

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE tmp(
	SELECT * FROM movies
)

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM tmp
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT COUNT(genres.name) AS Numero_peliculas, genres.name FROM movies 
JOIN genres ON movies.genre_id = genres.id
GROUP BY genres.name
HAVING Numero_peliculas >= 1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT actors.* FROM actors 
JOIN movies ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_title ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- El indice mejorará el rendimiento de las consultas en tablas grandes.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Un índice en genre_id aceleraría la búsqueda de películas por género y las consultas que agrupan o cuentan películas por género.

