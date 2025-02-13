SELECT * FROM movies;

SELECT first_name, last_name, rating FROM actors;

SELECT title AS titulo FROM series AS series_español;

SELECT first_name, last_name, rating FROM actors WHERE rating > 7.5;

SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;

SELECT title, rating FROM movies ORDER BY rating DESC;

SELECT title FROM movies LIMIT 3;

SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;

SELECT first_name FROM actors LIMIT 10;

SELECT title, rating FROM movies WHERE title = "Toy Story";

SELECT first_name FROM actors WHERE actors.first_name LIKE 'Sam%';

SELECT title FROM movies WHERE movies.release_date BETWEEN "2004-01-01" AND "2008-01-01";

SELECT title, rating, release_date, awards FROM movies WHERE rating > 3 AND awards > 1 AND movies.release_date BETWEEN "1998-01-01" AND "2009-12-31" ORDER BY rating DESC;