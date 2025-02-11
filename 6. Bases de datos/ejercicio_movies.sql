/* Mostrar todos los registros de la tabla de movies. */

SELECT
	*
from
	movies m;

/* Mostrar el nombre, apellido y rating de todos los actores. */
select
	a.first_name as nombre,
	a.last_name as apellido,
	a.rating
from
	actors a
order by
	a.rating desc;

/* Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.*/
select
	series.id as identificador,
	series.title as titulo,
	series.release_date as fecha_de_lanzamiento,
	series.end_date as fecha_de_finalizacion,
	genero.name genero
from
	series series
join genres genero on
	genero.id = series.genre_id;

/*Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.*/

SELECT
	actores.first_name nombre,
	actores.last_name apellidos
from
	actors actores
where
	actores.rating >= 7.5;

/*Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.*/

SELECT
	peliculas.title titulo,
	peliculas.rating
from
	movies peliculas
ORDER by
	peliculas.rating asc;

/*Mostrar los títulos de las primeras tres películas en la base de datos.*/

select
	peliculas.title
from
	movies peliculas
limit 3;

/*Mostrar el top 5 de las películas con mayor rating.*/

select
	*
from
	movies m
order by
	m.rating desc
limit 5;

/* Listar los primeros 10 actores. */

select
	*
from
	actors a
limit 10;

/*Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.*/
select
	m.title,
	m.rating
from
	movies m
where
	m.title like "Toy Story%";

/*Mostrar a todos los actores cuyos nombres empiezan con Sam.*/
select
	*
from 
	actors a
where 
	a.first_name like "sam%";

/*Mostrar el título de las películas que salieron entre el 2004 y 2008.*/

select
	m.title
from
	movies m
where
	m.release_date between "2004-01-01" and "2008-12-31";

/*Traer el título de las películas con el rating mayor a 3, 
 * con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. 
 * Ordenar los resultados por rating.
*/


select
	m.title,
	m.rating
from
	movies m
where
	m.rating > 3
	and m.awards > 1
	and m.release_date between "1988-01-01" and "2009-12-31"
order by
	m.rating desc;
