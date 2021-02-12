CREATE TABLE motorcycle (
    id SERIAL PRIMARY KEY,
    brand VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    cubicCylinder INT NOT NULL,
    manufactureYear INT NOT NULL,
    modelYear INT NOT NULL,
    price NUMERIC(11,2) NOT NULL
);