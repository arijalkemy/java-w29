USE movies_db

-- 1 Agregar una película a la tabla movies.
INSERT INTO `movies` (`title`, `rating`, `awards`, `release_date`, `length`, `genre_id`)
VALUES ('Inception', 8.8, 10, '2010-07-16 00:00:00', 148, 5);

-- 2 Agregar un género a la tabla genres.
INSERT INTO `genres` (`created_at`, `name`, `ranking`, `active`)
VALUES (NOW(), 'Romance', 13, 1);

-- 3 Asociar a la película del punto 1. genre el género creado en el punto 2.
SELECT id FROM `genres` WHERE `name` = 'Romance';
UPDATE `movies`
SET `genre_id` = 13
WHERE `title` = 'Inception';

-- 4 Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
SELECT id FROM `movies` WHERE `title` = 'Inception';
UPDATE `actors`
SET `favorite_movie_id` = 22
WHERE `id` = 3;

-- 5 Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies LIKE movies;

INSERT INTO temp_movies SELECT * FROM movies;

SELECT * FROM temp_movies;


-- 6 Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM temp_movies WHERE awards < 5 AND id IS NOT NULL;


-- 7 Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name
FROM genres g
         JOIN movies m ON g.id = m.genre_id
GROUP BY g.id, g.name;

-- 8 Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.id, a.first_name, a.last_name, m.title
FROM actors a
         JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9 Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_name ON movies (title);

-- 10 Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies;

-- 11 En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si existe una mejora notable en la base de datos movies al crear indices, ya que con un número considerable de registros y consultas
-- que filtran por campos como genre_id, release_date, title, etc., la creación de índices en esos
-- campos puede proporcionar mejoras sustanciales en el rendimiento de las consultas.

-- 12 ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Crearía un índice en la columna ranking de la tabla genres asi optimizaría las consultas que ordenan o filtran por esta columna.
