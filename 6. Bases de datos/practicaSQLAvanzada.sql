
SELECT * FROM movies mo LEFT JOIN actors ac ON mo.id = ac.favorite_movie_id;

--  Mostrar el título y el nombre del género de todas las series.
select s.title as "Titulo serie",
g.name as "Genero"
from series s
inner join genres g on g.id = s.genre_id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select e.title as "titulo episodio",
concat(a.first_name, " ", a.last_name) as "Nombre completo"
from episodes e 
inner join actor_episode ae on ae.episode_id = e.id 
inner join actors a on a.id = ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title as "Titulo serie",
count(*) as "total temporadas"
from series s 
inner JOIN seasons s2 on s2.serie_id = s.id 
GROUP by s.id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name,
count(*) as total_movies
from genres g 
inner join movies m on m.genre_id = g.id 
GROUP BY g.id
HAVING total_movies >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT 
concat(a.first_name, " ", a.last_name) as "Nombre completo"
from actor_movie am 
inner join actors a on a.id = am.actor_id 
inner join movies m  on m.id  = am.movie_id 
where m.title like "La Guerra de las galaxias%"
GROUP BY a.id;




