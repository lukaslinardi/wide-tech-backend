-- V1__Create_products_table.sql
CREATE TABLE carts (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    type INT NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL
);