
# CarritoGT - Documentación de la API REST

## 1. Descripción general

CarritoGT es un sistema de carrito de compras desarrollado con Java y Spring Boot. La aplicación permite consultar productos almacenados en MariaDB, agregarlos al carrito, consultar las cantidades y eliminar productos.

La comunicación entre el frontend y el backend se realiza mediante solicitudes HTTP y respuestas en formato JSON.

## 2. Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- MariaDB
- HTML
- CSS
- JavaScript
- Maven

## 3. Dirección base

La API se ejecuta localmente en:

http://localhost:8080

## 4. Endpoints disponibles

### 4.1 Consultar productos

**Método:** GET

**Ruta:** `/api/productos`

**Descripción:** Devuelve la lista de productos registrados en la base de datos.

**Ejemplo de respuesta JSON:**

```json
[
  {
    "idProducto": 1,
    "nombre": "FinePix Pro2 3D Camera",
    "codigo": "3DcAM01",
    "imagen": "images/product/camera.jpg",
    "precio": 671.21
  }
]
```

La respuesta real incluye los productos disponibles en la base de datos.

### 4.2 Consultar el carrito

**Método:** GET

**Ruta:** `/api/carrito`

**Descripción:** Devuelve los productos que se encuentran en el carrito del usuario de prueba.

Cada elemento incluye el identificador del registro, el producto y la cantidad agregada.

**Ejemplo de solicitud:**

```http
GET /api/carrito
```

### 4.3 Agregar un producto al carrito

**Método:** POST

**Ruta:** `/api/carrito/agregar`

**Descripción:** Agrega un producto al carrito. Si el producto ya existe en el carrito del usuario de prueba, aumenta su cantidad.

**Encabezado:**

```http
Content-Type: application/json
```

**Ejemplo del cuerpo de la solicitud:**

```json
{
  "idProducto": 1,
  "cantidad": 1
}
```

**Descripción de los campos:**

- `idProducto`: identificador del producto que se desea agregar.
- `cantidad`: unidades que se desean agregar.

La respuesta devuelve el registro del carrito creado o actualizado.

### 4.4 Eliminar un producto del carrito

**Método:** DELETE

**Ruta:** `/api/carrito/{id}`

**Descripción:** Elimina un registro del carrito utilizando su identificador.

**Ejemplo de solicitud:**

```http
DELETE /api/carrito/10
```

En este ejemplo, `10` representa el identificador del registro que se desea eliminar.

**Ejemplo de respuesta:**

```json
{
  "mensaje": "Producto eliminado del carrito"
}
```

El identificador del ejemplo debe sustituirse por uno que exista en el carrito.

## 5. Validaciones y manejo de errores

La aplicación valida que la cantidad de productos sea mayor que cero y comprueba que el producto exista antes de agregarlo.

Si el producto solicitado no existe, la operación no se completa. Si se intenta eliminar un registro inexistente, también se genera un error.

La aplicación utiliza las respuestas HTTP de Spring Boot para comunicar el resultado de las solicitudes.

## 6. Arquitectura del backend

El backend está organizado en capas:

- **Controller:** recibe las solicitudes HTTP y devuelve las respuestas.
- **Service:** contiene la lógica del carrito y de los productos.
- **Repository:** permite consultar y modificar los datos mediante Spring Data JPA.
- **Entity:** representa las tablas de la base de datos.

## 7. Base de datos

La aplicación utiliza MariaDB y trabaja con dos tablas principales:

- `producto`: almacena los datos de los productos.
- `shopping_cart`: almacena los productos agregados al carrito y sus cantidades.

## 8. Consideraciones

Esta versión utiliza un usuario de prueba fijo para el carrito. No implementa autenticación ni carritos independientes para distintos usuarios.

El frontend consume los endpoints mediante JavaScript y la función `fetch()`.
