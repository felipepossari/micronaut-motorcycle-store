CREATE TABLE motorcycle (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    cubic_cylinder INT NOT NULL,
    manufacture_year INT NOT NULL,
    model_year INT NOT NULL,
    price NUMERIC(11,2) NOT NULL
);