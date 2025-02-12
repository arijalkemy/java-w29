use movies_db;

# Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name FROM series se 
JOIN genres ge ON se.genre_id = ge.id;
# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, a.first_name, a.last_name FROM actors a
JOIN actor_episode ae ON a.id = ae.actor_id
JOIN episodes ep ON ae.episode_id = ep.id;
# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(se.id) total_temporadas FROM series s
JOIN seasons se ON se.serie_id = s.id
GROUP BY s.title;
# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT ge.name, COUNT(m.id) AS total_peliculas
FROM genres ge
JOIN movies m ON m.genre_id = ge.id
GROUP BY ge.name
HAVING COUNT(m.id) >= 3;
# Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de 
# la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
JOIN actor_movie am ON am.actor_id = a.id
JOIN movies m ON m.id = am.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias:%';
SELECT * FROM movies;