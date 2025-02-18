-- select * from movies;
-- select first_name,last_name,rating from actors;
-- select first_name,last_name,rating from actors as caca where rating > 7.5;
-- select title as titulo,rating as puntaje,awards as premios from movies movies where rating > 7.5 and awards > 2;
-- select title, rating from movies order by rating;
-- select title from movies limit 3;
-- select title, rating from movies order by rating desc limit 5;
-- select first_name as nombre, last_name as apellido from actors limit 10;
-- select title, rating from movies where title like "Toy Story%";
-- select first_name, last_name from actors where first_name like "Sam%";
-- select title,release_date from movies where release_date between '2004-01-01' and '2008-12-31' order by release_date;
/*Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento
 entre el año 1988 al 2009. Ordenar los resultados por rating.*/
select title from movies 
where rating  > 3 
and awards > 1 
and release_date between '1998-01-01' and '2009-12-31' 
order by rating;