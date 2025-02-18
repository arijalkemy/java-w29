use movies_db;
/*Con la base de datos “movies”, se propone crear una tabla temporal llamada 
“TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
Realizar una consulta a la tabla temporal para ver los episodios de la 
primera temporada.
*/
create temporary table twd
select
 s.title as serie,
 t.title as temporada,
 e.title as episodio
from series as s
inner join seasons as t on t.serie_id = s.id
inner join episodes as e on  e.season_id =  t.id 
where s.title = "The Walking Dead";

select * from twd;

/*En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear
 la creación del mismo.
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.*/

explain select * from movies where length = 120;

