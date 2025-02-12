use movies_db;
# Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD”
# y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD2 AS 
SELECT se.id, ep.title, s.number FROM episodes ep
JOIN seasons s on ep.season_id = s.id
JOIN series se on s.serie_id = se.id
WHERE se.title = 'The Walking Dead';

# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM TWD2 WHERE number = 1;

# En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX movies_idx
ON movies(id);
SHOW INDEX FROM movies;

# Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22, null, null, 'Laberinto del fauno', 9.0, 5, '1988-02-04 00:00:00', 120, 11);
# Agregar un género a la tabla genres.
INSERT INTO genres values (13, '2025-02-11 00:00:00', null, 'Chick flick', 13, 1);
# Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;
SELECT * FROM movies;
# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 1;
# Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE moviescopy 
SELECT * FROM movies;
SELECT * FROM moviescopy;
# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM moviescopy WHERE awards < 5;
SET SQL_SAFE_UPDATES = 1;
# Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM genres
WHERE id IN (SELECT genre_id FROM movies);
# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * FROM actors
WHERE favorite_movie_id IN (SELECT id FROM movies WHERE awards > 3);
# Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX moviename
ON movies(title);
# Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Sí, crear índices puede mejorar significativamente el rendimiento,
-- sobre todo en consultas frecuentes con WHERE, JOIN, ORDER BY o GROUP BY.
# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Si existe una tabla actors_movies que relaciona actores con películas 
-- (id_actor, id_movie), los índices ayudarían a optimizar los JOIN.
CREATE INDEX idx_actor_movie ON actors_movies(id_actor, id_movie);