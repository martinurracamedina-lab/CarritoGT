# Bitácora de trabajo — CarritoGT

## 1. Datos generales

- **Nombre del proyecto:** CarritoGT
- **Tipo de proyecto:** Aplicación web con API REST
- **Tecnologías principales:** Java, Spring Boot, Maven, MariaDB, HTML, CSS y JavaScript.
- **Entorno de desarrollo:** Lubuntu ejecutado en una máquina virtual mediante VirtualBox.
- **Control de versiones:** Git.

## 2. Registro de actividades

### Actividad 1. Preparación del proyecto

Se preparó el entorno de desarrollo en Lubuntu y se organizó el espacio de trabajo para desarrollar el proyecto CarritoGT. Se utilizó Java y Maven para preparar la aplicación con Spring Boot.

### Actividad 2. Configuración de la base de datos

Se trabajó con la base de datos MariaDB llamada `cc`, que contiene las tablas `producto` y `shopping_cart`. Se utilizaron los productos registrados en la base de datos para realizar las pruebas de la aplicación.

### Actividad 3. Desarrollo de la API REST

Se crearon las clases correspondientes a las entidades, los repositorios, los servicios y los controladores. Se implementaron operaciones para consultar productos, consultar el carrito, agregar productos, incrementar cantidades y eliminar artículos.

### Actividad 4. Desarrollo de la tienda web

Se preparó la interfaz web de CarritoGT con HTML, CSS y JavaScript. Se conectó la interfaz con la API mediante solicitudes `fetch` para mostrar los productos y administrar el carrito de compras.

### Actividad 5. Incorporación de imágenes

Se incorporaron imágenes de los productos a la aplicación web. Se verificó que las imágenes de la cámara, el disco duro, la computadora portátil y el reloj se mostraran correctamente en la tienda.

### Actividad 6. Pruebas funcionales

Se realizaron pruebas de los endpoints de la API para comprobar la consulta de productos, la consulta del carrito, la incorporación de productos, el incremento de cantidades y la eliminación de artículos. Las operaciones probadas funcionaron correctamente.

### Actividad 7. Documentación técnica

Se prepararon los archivos `README.md`, `documentacion/API.md` y `documentacion/PRUEBAS.md` para describir el proyecto, documentar los endpoints y registrar las pruebas realizadas.

### Actividad 8. Control de versiones con Git

Se inicializó un repositorio Git local, se configuró la identidad del autor y se creó el primer commit con el mensaje:

`Inicializa proyecto CarritoGT con API y tienda web`

El commit inicial permitió guardar una primera versión del código y la documentación del proyecto.

## 3. Actividades pendientes

- Completar y revisar la documentación final.
- Elaborar los diagramas solicitados para representar la arquitectura y el funcionamiento del sistema.
- Ampliar las pruebas de la API y registrar sus resultados.
- Verificar los requisitos completos del proyecto.
- Preparar las evidencias de las actividades realizadas.
- Revisar el repositorio y preparar la entrega final.

## 4. Observaciones

El proyecto cuenta con una tienda web conectada a una API REST desarrollada con Spring Boot y una base de datos MariaDB. Las funciones principales probadas permiten consultar productos y gestionar los artículos del carrito. El trabajo continuará con la documentación, las pruebas adicionales y la preparación de la entrega final.
