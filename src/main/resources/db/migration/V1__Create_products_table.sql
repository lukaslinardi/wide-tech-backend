-- V1__Create_products_table.sql
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    type VARCHAR(255) NOT NULL
);

-- Insert initial values
INSERT INTO products (type) VALUES ('Book');
INSERT INTO products (type) VALUES ('Laptop');
