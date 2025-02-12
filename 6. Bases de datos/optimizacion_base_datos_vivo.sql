USE movies_db;
/*** Creación de Tablas Temporales e Índices ***/
	-- EJERCICIO 1
		CREATE TEMPORARY TABLE  IF NOT EXISTS TWD AS (

		SELECT e.*, sea.number AS season_number
		FROM episodes e
		JOIN seasons sea ON e.season_id = sea.id
		JOIN series ser ON sea.serie_id = ser.id
		WHERE ser.title = "The Walking Dead");

	-- EJERCICIO 2
		SELECT * FROM TWD where season_number = 1;


/*** Consultas SQL Avanzadas 2 ***/
	-- 1.Agregar una película a la tabla movies.
		INSERT INTO movies 
			(created_at,updated_at,title,rating,awards,release_date,length)
		VALUES
			(NOW(),NOW(),"Fast and Furious",8.1,2,NOW(),2.1);
            
	-- 2.Agregar un género a la tabla genres.
		INSERT INTO genres
			(created_at,updated_at,name,ranking,active)
		VALUES
			(NOW(),NOW(),"Carreras",13,1);
            
	-- 3.Asociar a la película del punto 1. genre el género creado en el punto 2.
		UPDATE movies 
        SET genre_id = 13 
        WHERE id = 22;
        
	-- 4.Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
		UPDATE actors 
        SET favorite_movie_id = 22 
        WHERE id = 1;
        
	-- 5.Crear una tabla temporal copia de la tabla movies.
		CREATE TEMPORARY TABLE IF NOT EXISTS movies_copy AS (
			SELECT * FROM movies
        );
        SELECT* FROM movies_copy;
        
	-- 6.Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
		DELETE FROM movies_copy WHERE awards < 5;
        SELECT* FROM movies_copy;
        
	-- 7.Obtener la lista de todos los géneros que tengan al menos una película.
		SELECT g.id,g.name, COUNT(*) AS number_movies
        FROM genres g
		JOIN movies m ON m.genre_id = g.id
        GROUP BY g.id
        HAVING number_movies >= 1;
        
	-- 8.Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
		SELECT a.id, a.first_name,a.last_name,m.title,m.awards
		FROM actors a
        JOIN movies m ON a.favorite_movie_id = m.id;
        
	-- Crear un índice sobre el nombre en la tabla movies.
		CREATE INDEX idx_title ON movies(title);
        
	-- Chequee que el índice fue creado correctamente.
		SHOW INDEX FROM  movies WHERE Key_name = "idx_title";
	-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
		/* 
			Si ya que no necesita entrar a comparar dato a dato, si no que por medio del indexamiento la consulta se realiza mucho
            mas rapidas y eficientes
        */	
		-- Consulta sin Index
			EXPLAIN
			SELECT * 
			FROM movies where rating = 1;
		
        -- Consulta con Index
		SELECT * 
		FROM movies where title = "Fast and Furious";
        
		-- Mostrando los tiempos de Ejecucion
		SHOW PROFILES;