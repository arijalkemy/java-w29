# 1
SELECT * FROM movies;
# 2
SELECT first_name, last_name, rating FROM actors;
# 3
SELECT title as 'titulo' FROM series as series;
# 4
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
# 5
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;
# 6
SELECT title, rating FROM movies ORDER BY rating;
# 7
SELECT title FROM movies LIMIT 3;
# 8
SELECT title, rating FROM movies ORDER BY rating DESC LIMIT 5;
# 9
SELECT * FROM actors LIMIT 10;
# 10
SELECT title, rating FROM movies WHERE title = 'Toy Story';
SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';
# 11
SELECT * FROM actors WHERE first_name LIKE 'Sam%';
# 12
SELECT title, release_date FROM movies WHERE YEAR(release_date) BETWEEN '2004' AND '2008';
SELECT title, release_date FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';
# 13
SELECT title, rating FROM movies WHERE rating > 3 AND awards > 1 AND YEAR(release_date) BETWEEN '1988' AND '2009' ORDER BY rating;