-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name 'genre'
FROM series s
         JOIN genres g
              ON s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title 'episode', a.first_name, a.last_name
FROM episodes e
         JOIN actor_episode ae
              ON ae.episode_id = e.id
         JOIN actors a
              ON a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(ss.id) 'seasons'
FROM series s
         JOIN seasons ss
              ON ss.serie_id = s.id
GROUP BY s.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(m.id) movies
FROM genres g
         JOIN movies m
              ON m.genre_id = g.id
GROUP BY m.id
HAVING movies > 3

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
         JOIN actor_movie am
              ON am.actor_id = a.id
         JOIN movies m
              ON m.id = am.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%';