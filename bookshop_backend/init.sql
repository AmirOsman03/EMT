-- Country
CREATE TABLE country (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         continent VARCHAR(255) NOT NULL
);

-- Author
CREATE TABLE authors (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         surname VARCHAR(255) NOT NULL,
                         country_id BIGINT,
                         CONSTRAINT fk_author_country FOREIGN KEY (country_id) REFERENCES country(id)
);

-- Category
CREATE TABLE category (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(4000)
);

-- Manufacturer
CREATE TABLE manufacturers (
                               id SERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               manufacturer_address VARCHAR(255)
);

-- Product
CREATE TABLE product (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DOUBLE PRECISION,
                         quantity INTEGER,
                         category_id BIGINT,
                         manufacturer_id BIGINT,
                         CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id),
                         CONSTRAINT fk_product_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id)
);

-- User
CREATE TABLE shop_users (
                            username VARCHAR(255) PRIMARY KEY,
                            password VARCHAR(255) NOT NULL,
                            name VARCHAR(255),
                            surname VARCHAR(255),
                            role VARCHAR(50),
                            is_account_non_expired BOOLEAN DEFAULT TRUE,
                            is_account_non_locked BOOLEAN DEFAULT TRUE,
                            is_credentials_non_expired BOOLEAN DEFAULT TRUE,
                            is_enabled BOOLEAN DEFAULT TRUE
);

-- ShoppingCart
CREATE TABLE shopping_cart (
                               id SERIAL PRIMARY KEY,
                               date_created TIMESTAMP,
                               user_username VARCHAR(255),
                               status VARCHAR(50),
                               CONSTRAINT fk_cart_user FOREIGN KEY (user_username) REFERENCES shop_users(username)
);

-- Many-to-Many relation: ShoppingCart <-> Product
CREATE TABLE shopping_cart_products (
                                        shopping_cart_id BIGINT NOT NULL,
                                        products_id BIGINT NOT NULL,
                                        PRIMARY KEY (shopping_cart_id, products_id),
                                        CONSTRAINT fk_cart FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id),
                                        CONSTRAINT fk_product FOREIGN KEY (products_id) REFERENCES product(id)
);
