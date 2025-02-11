-- 1
INSERT INTO movies VALUES (22, NULL, NULL, 'Interestellar', 10.0, 17, '2014-10-04 00:00:00', 180, NULL);

-- 2
INSERT INTO genres VALUES (13, NOW(), NOW(), 'Perfeccion', 13, 1);

-- 3
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- 4
UPDATE actors SET favorite_movie_id = 22 WHERE id = 48;

-- 5
CREATE TEMPORARY TABLE movies_copy SELECT * FROM movies;

-- 6
DELETE FROM movies_copy WHERE awards < 5;

-- 7
SELECT DISTINCT g.* FROM genres g
JOIN movies m ON m.genre_id = g.id;

-- 8
SELECT a.* FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9
CREATE INDEX mv_title_idx ON movies(title);

-- 10 Hay manera programáticamente?

-- 11 En el estado actual, creo que no, tiene muy pocos datos y la mejora al crear indices no creo que sea muy notable para un usuario final

-- 12 Crearía un indice en el nombre de las series, ya que es de las búsquedas mas comunes que un usuario haría


