
-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT s.title AS Titulo, g.name AS Género 
FROM series s
INNER JOIN genres g 
ON s.genre_id=g.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title AS Titulo,a.first_name AS Nombre,a.last_name AS Apellido 
FROM episodes e
INNER JOIN actor_episode ae 
ON e.id=ae.episode_id
INNER JOIN actors a 
ON a.id=ae.actor_id; 

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT ser.title AS Titulo, COUNT(*) AS Temporadas
FROM series ser
INNER JOIN seasons sea ON ser.id = sea.serie_id
GROUP BY ser.title;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) 
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name
HAVING COUNT(*) >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name 
FROM actors a
INNER JOIN actor_movie ac ON a.id = ac.actor_id
INNER JOIN movies m ON m.id = ac.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%';