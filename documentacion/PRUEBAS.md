
# CarritoGT - Informe de pruebas de la API

## 1. Objetivo

Verificar el funcionamiento de los endpoints principales de la API REST de CarritoGT mediante solicitudes HTTP realizadas con curl.

## 2. Entorno de pruebas

- Sistema operativo: Lubuntu.
- Backend: Java y Spring Boot.
- Base de datos: MariaDB.
- Herramienta de pruebas: curl.
- Dirección base: http://localhost:8080.

## 3. Pruebas realizadas

### Prueba 1. Consultar productos

- Método: GET.
- Ruta: `/api/productos`.
- Resultado esperado: recibir la lista de productos en formato JSON.
- Resultado obtenido: la solicitud respondió correctamente y mostró los productos.
- Estado: APROBADA.

### Prueba 2. Consultar carrito

- Método: GET.
- Ruta: `/api/carrito`.
- Resultado esperado: recibir los registros del carrito en formato JSON.
- Resultado obtenido: la API permitió consultar el carrito.
- Estado: APROBADA.

### Prueba 3. Agregar producto

- Método: POST.
- Ruta: `/api/carrito/agregar`.
- Datos enviados: identificador del producto y cantidad en formato JSON.
- Resultado esperado: agregar el producto al carrito.
- Resultado obtenido: el producto se agregó correctamente.
- Estado: APROBADA.

### Prueba 4. Aumentar cantidad

- Método: POST.
- Ruta: `/api/carrito/agregar`.
- Datos enviados: el mismo producto con cantidad 1.
- Resultado esperado: aumentar la cantidad del producto existente.
- Resultado obtenido: se comprobó que la cantidad aumentó.
- Estado: APROBADA.

### Prueba 5. Eliminar producto

- Método: DELETE.
- Ruta: `/api/carrito/{id}`.
- Resultado esperado: eliminar el registro seleccionado del carrito.
- Resultado obtenido: la API confirmó la eliminación y se verificó el carrito nuevamente.
- Estado: APROBADA.

## 4. Conclusión

Las pruebas realizadas permitieron comprobar el funcionamiento de las operaciones principales de la API REST de CarritoGT: consulta de productos, consulta del carrito, agregado de productos, actualización de cantidades y eliminación de registros.

La API se comunica con la base de datos MariaDB y devuelve respuestas en formato JSON para que el frontend pueda mostrar la información.

## 5. Observaciones

Las pruebas se realizaron localmente utilizando curl. Para completar la evidencia del proyecto, se recomienda conservar capturas de pantalla de las solicitudes y sus respuestas.

## Pruebas automatizadas con Maven

Se utiliza JUnit 5 junto con Spring Boot Test para ejecutar pruebas automatizadas del proyecto.

### Prueba 1. Inicio de la aplicación

- **Método:** `contextLoads()`
- **Objetivo:** comprobar que el contexto de Spring Boot pueda iniciar.
- **Resultado esperado:** la aplicación de prueba inicia sin errores.

### Prueba 2. Consulta de productos

- **Método:** `debeConsultarProductos()`
- **Endpoint:** `GET /api/productos`
- **Objetivo:** comprobar que la API responda correctamente al consultar los productos.
- **Validaciones:** se verifica que el código HTTP sea `200` y que el cuerpo de la respuesta no sea nulo.

### Ejecución

Para ejecutar las pruebas automatizadas desde la raíz del proyecto, se utiliza:

```bash
./mvnw test
```

El resultado debe revisarse en la salida de Maven. Una ejecución exitosa muestra `BUILD SUCCESS` y cero fallos o errores.

### Observación

Estas pruebas comprueban el inicio de la aplicación y la respuesta del endpoint de productos. Las operaciones del carrito requieren pruebas adicionales para validar sus distintos comportamientos.
