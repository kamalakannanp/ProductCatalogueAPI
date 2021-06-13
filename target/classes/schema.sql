drop table if exists product;

CREATE TABLE product (
  product_id INT,
  product_name VARCHAR(250) NOT NULL,
  product_desc VARCHAR(50) DEFAULT NULL,
  brand VARCHAR(50) DEFAULT NULL,
  price DOUBLE,
  size INT,
  discount INT,
  created_date TIMESTAMP default now()

);