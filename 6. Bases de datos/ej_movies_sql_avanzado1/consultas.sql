use movies_db;

-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name FROM series s JOIN genres g ON s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title AS 'Título de episodio', a.first_name, a.last_name
FROM episodes e
    JOIN actor_episode ae ON ae.episode_id = e.id
    JOIN actors a ON a.id = ae.actor_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(*) AS "Total de temporadas"
FROM SERIES S
    JOIN seasons se ON s.id = se.serie_id
GROUP BY s.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) AS "Cantidad de películas"
FROM genres g
    JOIN movies m ON m.genre_id = g.id
GROUP BY g.name;

-- 5. Mostrar solo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT a.first_name, a.last_name
FROM actors a
    JOIN actor_movie am ON a.id = am.actor_id
    JOIN movies m ON m.id = am.movie_id
GROUP BY a.first_name, a.last_name
    HAVING COUNT(*) = (SELECT COUNT(*) FROM movies WHERE title LIKE "%La guerra de las galaxias%");
