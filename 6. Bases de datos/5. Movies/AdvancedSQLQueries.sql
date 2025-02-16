-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title AS Titulo, g.name AS Genero
FROM series AS s 
JOIN genres AS g
WHERE s.genre_id = g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title AS TituloEpisodio, a.first_name AS NombreActor, a.last_name AS ApellidoActor
FROM episodes AS e
JOIN actor_episode AS ae ON e.number = ae.episode_id
JOIN actors AS a ON ae.actor_id = a.id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title AS Titulo, COUNT(seasons.serie_id) AS TotalTemporadas
FROM series
LEFT JOIN episodes ON series.id = episodes.season_id
LEFT JOIN seasons ON episodes.season_id = seasons.serie_id
GROUP BY series.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name AS Genero, COUNT(movies.id) AS TotalPeliculas
FROM genres
JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING COUNT(movies.id) >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name AS Nombre, actors.last_name AS Apellido
FROM actors
JOIN actor_movie ON actor_movie.actor_id = actors.id
JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE "La Guerra de las galaxias%";