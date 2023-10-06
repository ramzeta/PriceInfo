INSERT INTO BRAND (BRAND_ID, BRAND_NAME) VALUES (1, 'Apple');
INSERT INTO BRAND (BRAND_ID, BRAND_NAME) VALUES (2, 'Samsung');
INSERT INTO BRAND (BRAND_ID, BRAND_NAME) VALUES (3, 'Sony');
INSERT INTO BRAND (BRAND_ID, BRAND_NAME) VALUES (4, 'Microsoft');
INSERT INTO BRAND (BRAND_ID, BRAND_NAME) VALUES (5, 'Dell');

INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME) VALUES (1, 'iPhone 13');
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME) VALUES (2, 'Galaxy S21');
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME) VALUES (3, 'PlayStation 5');
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME) VALUES (4, 'Surface Laptop');
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME) VALUES (5, 'Dell XPS 13');
INSERT INTO PRODUCT (PRODUCT_ID, PRODUCT_NAME) VALUES (35455, 'Prueba');

INSERT INTO PRICE_INFO (priceInfoId, id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES
(1, 1, 1, '2020-06-14 00:00:00.0', '2020-12-31 23:59:59.0', 1, 35455, 0, 35.50, 'EUR'),
(2, 2, 1, '2020-06-14 15:00:00.0', '2020-06-14 18:30:00.0', 2, 35455, 1, 25.45, 'EUR'),
(3, 3, 1, '2020-06-15 00:00:00.0', '2020-06-15 11:00:00.0', 3, 35455, 1, 30.50, 'EUR'),
(4, 4, 1, '2020-06-15 16:00:00.0', '2020-12-31 23:59:59.0', 4, 35455, 1, 38.95, 'EUR');