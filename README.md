
# CarritoGT

## Descripción

CarritoGT es una aplicación web de carrito de compras desarrollada como proyecto académico. Permite consultar productos, agregarlos al carrito, modificar las cantidades mediante nuevas adiciones y eliminar productos.

El proyecto utiliza una API REST desarrollada con Java y Spring Boot, una base de datos MariaDB y una interfaz web construida con HTML, CSS y JavaScript.

## Objetivo

Implementar una aplicación cliente-servidor organizada por capas que permita administrar productos y operaciones básicas de un carrito de compras mediante solicitudes HTTP y respuestas JSON.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Maven
- MariaDB
- HTML5
- CSS3
- JavaScript
- Git

## Funcionalidades

- Consultar los productos disponibles.
- Mostrar el nombre, código, precio e imagen de cada producto.
- Agregar productos al carrito.
- Aumentar la cantidad de un producto existente.
- Consultar el contenido del carrito.
- Calcular el total de la compra en la interfaz.
- Eliminar productos del carrito.

## Arquitectura

El backend está organizado en cuatro capas principales:

- **Controller:** recibe las solicitudes HTTP.
- **Service:** contiene la lógica de negocio.
- **Repository:** consulta y modifica la información almacenada.
- **Entity:** representa las tablas de la base de datos.

## Base de datos

La aplicación utiliza MariaDB con las siguientes tablas:

- `producto`: contiene los productos disponibles.
- `shopping_cart`: registra los productos agregados y sus cantidades.

La configuración de conexión se encuentra en `src/main/resources/application.properties`.

## Endpoints de la API

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/productos` | Consultar productos |
| GET | `/api/carrito` | Consultar el carrito |
| POST | `/api/carrito/agregar` | Agregar un producto |
| DELETE | `/api/carrito/{id}` | Eliminar un registro del carrito |

La documentación ampliada se encuentra en `documentacion/API.md`.

## Requisitos para ejecutar el proyecto

- Java 21.
- MariaDB en funcionamiento.
- La base de datos `cc` configurada con las tablas y datos necesarios.
- Acceso a una terminal.

## Ejecución

1. Iniciar MariaDB.
2. Verificar que la conexión a la base de datos esté configurada correctamente.
3. Abrir una terminal en la carpeta raíz del proyecto.
4. Ejecutar:

   ```bash
   ./mvnw spring-boot:run
   ```

5. Abrir el navegador en:

   http://localhost:8080/

## Pruebas

Se realizaron pruebas de los endpoints utilizando `curl` para consultar productos, consultar el carrito, agregar productos, aumentar cantidades y eliminar registros.

El informe de las pruebas está disponible en `documentacion/PRUEBAS.md`.

## Alcance actual

Esta versión utiliza un usuario de prueba fijo para el carrito. No incluye autenticación ni carritos independientes para múltiples usuarios.

## Autoría

Proyecto académico de Ingeniería en Sistemas.
