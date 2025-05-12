CREATE MATERIALIZED VIEW books_per_author AS
SELECT
    a.id AS author_id,
    COUNT(b.id) AS num_books
FROM
    authors a
        LEFT JOIN
    books b ON b.author_id = a.id
GROUP BY
    a.id;

CREATE MATERIALIZED VIEW authors_per_country AS
SELECT
    country_id,
    COUNT(*) AS num_authors
FROM
    authors a
GROUP BY
    country_id;