SELECT title
    FROM movies
             WHERE rating > 3
               AND awards > 1
               AND YEAR(release_date) BETWEEN 1988 AND 2009
    ORDER BY rating;