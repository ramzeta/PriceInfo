# README.md para la API de Precios en Spring Boot

## Descripción

Este proyecto es una API REST construida con Spring Boot para gestionar precios de productos en diferentes cadenas de tiendas. La API utiliza una base de datos en memoria H2 y se expone en el puerto 8001.

## Características

- Consulta de precios de productos por fecha, identificador de producto y cadena.
- Gestión de marcas (brands) y productos.
- Base de datos en memoria H2.
- Documentación de API con Swagger.

## Endpoints

### Precios

- Consulta de precios: `GET /price-info`

### Marcas

- Obtener todas las marcas: `GET /brands`
- Obtener una marca por ID: `GET /brands/{id}`
- Actualizar una marca: `PUT /brands`
- Eliminar una marca: `DELETE /brands/{id}`
- Crear una nueva marca: `POST /brands`

### Productos

- Obtener todos los productos: `GET /products`
- Actualizar un producto existente: `PUT /products`
- Obtener un producto por ID: `GET /products/{id}`
- Eliminar un producto: `DELETE /products/{id}`
- Crear un nuevo producto: `POST /products`

## Docker Compose

Para ejecutar este proyecto, asegúrese de tener Docker y Docker Compose instalados en su máquina. Luego, inicie la API en el puerto 8001 y también expondrá la documentación de Swagger en la misma dirección.

## Postman Collection

Para probar los endpoints, puede importar la colección de Postman proporcionada. [Enlace a la colección de Postman](https://red-equinox-520925.postman.co/workspace/c6f59379-d572-4a3a-8f1c-42b6ba432f19/collection/8411939-353a5f52-7963-4473-84cc-74f0b7688a3c?action=share&source=collection_link&creator=8411939)

## Pruebas

Se han implementado pruebas para validar los siguientes escenarios:

- Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
- Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
- Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (CADENA1)
- Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (CADENA1)
- Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (CADENA1)

## Autor

Ramiro Perez Sanz 

## Licencia

Este proyecto está bajo la Licencia MIT - vea el archivo [LICENSE.md](LICENSE.md) para más detalles.
