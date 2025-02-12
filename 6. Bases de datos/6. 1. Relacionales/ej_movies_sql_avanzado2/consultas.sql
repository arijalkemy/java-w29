-- 1. Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id) VALUES (
    'Past Lives',
    8.4,
    7,
    '2023-06-02',
    103,
    3);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres (name, created_at, ranking, active) VALUES (
    'Ficción',
    '2016-07-04 03:00:00',
    13,
    1
);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE title = 'Past Lives';

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp AS SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name
FROM genres g
WHERE g.id IN (SELECT m.genre_id FROM movies m WHERE m.genre_id = g.id);

SELECT g.id, g.name
FROM genres g
    JOIN movies m ON m.genre_id = g.id
GROUP BY g.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.id, a.first_name, a.last_name FROM actors a
WHERE a.favorite_movie_id IN (SELECT m.id FROM movies m WHERE m.awards > 3);

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_title ON movies(title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies;
