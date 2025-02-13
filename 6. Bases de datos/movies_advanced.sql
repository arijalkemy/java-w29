-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length)
SELECT CURRENT_DATE, CURRENT_DATE, 'Tiempo de Valientes', 9, 0, '2004-12-12', 120
WHERE NOT EXISTS (SELECT 1 FROM movies WHERE title = 'Tiempo de Valientes' AND release_date = '2004-12-12');

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active)
SELECT CURRENT_DATE, CURRENT_DATE, 'Deporte', 13, 1
WHERE NOT EXISTS (SELECT 1 FROM genres WHERE name = 'Deporte');

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
SET SQL_SAFE_UPDATES = 0;

UPDATE movies m
SET m.genre_id = (SELECT DISTINCT g.id FROM genres g WHERE g.name = 'Deporte'),
	m.updated_at = CURRENT_DATE
WHERE m.title = 'Tiempo de Valientes';

SET SQL_SAFE_UPDATES = 1;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SET SQL_SAFE_UPDATES = 0;

UPDATE actors a
SET a.favorite_movie_id = (SELECT m.id FROM movies m WHERE m.title = 'Tiempo de Valientes' LIMIT 1),
	a.updated_at = CURRENT_DATE
WHERE a.id = 1;

UPDATE actor_movie am
SET am.movie_id = (SELECT DISTINCT m.id FROM movies m WHERE m.title = 'Tiempo de Valientes' LIMIT 1),
	am.updated_at = CURRENT_DATE
WHERE am.actor_id = 1;

SET SQL_SAFE_UPDATES = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE IF NOT EXISTS movies_copy AS
SELECT * FROM movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;

DELETE FROM movies_copy
WHERE awards < 5;

SET SQL_SAFE_UPDATES = 1;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.*
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*
FROM actors a
INNER JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_title ON movies_copy(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies_copy;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Basado en las consultas que hice crearia indices en los atributos que mas frecuentemente visito, como:
-- genres.id
-- actors.favorite_movie_id
-- actor_movie.actor_id y actor_movie.movie_id 