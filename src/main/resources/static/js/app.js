
const API_PRODUCTOS = "/api/productos";
const API_CARRITO = "/api/carrito";

const contenedorProductos = document.getElementById("productos");
const contenedorCarrito = document.getElementById("items-carrito");
const elementoTotal = document.getElementById("total");
const elementoMensaje = document.getElementById("mensaje");

function mostrarMensaje(texto) {
    elementoMensaje.textContent = texto;
}

async function cargarProductos() {
    try {
        const respuesta = await fetch(API_PRODUCTOS);

        if (!respuesta.ok) {
            throw new Error("No se pudieron cargar los productos.");
        }

        const productos = await respuesta.json();
        contenedorProductos.innerHTML = "";

        productos.forEach(producto => {
            const tarjeta = document.createElement("article");
            tarjeta.className = "producto";

            const imagen = document.createElement("img");
            const archivoImagen = producto.imagen.split("/").pop();
            imagen.src = "/images/product/" + archivoImagen;
            imagen.alt = producto.nombre;

            const nombre = document.createElement("h3");
            nombre.textContent = producto.nombre;

            const codigo = document.createElement("p");
            codigo.textContent = "Código: " + producto.codigo;

            const precio = document.createElement("p");
            precio.className = "precio";
            precio.textContent = "Q" + Number(producto.precio).toFixed(2);

            const boton = document.createElement("button");
            boton.textContent = "Agregar al carrito";
            boton.addEventListener("click", () => {
                agregarAlCarrito(producto.idProducto);
            });

            tarjeta.append(imagen, nombre, codigo, precio, boton);
            contenedorProductos.appendChild(tarjeta);
        });
    } catch (error) {
        contenedorProductos.textContent = "Error al cargar los productos.";
        mostrarMensaje(error.message);
    }
}

async function agregarAlCarrito(idProducto) {
    try {
        const respuesta = await fetch(API_CARRITO + "/agregar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                idProducto: idProducto,
                cantidad: 1
            })
        });

        if (!respuesta.ok) {
            throw new Error("No se pudo agregar el producto.");
        }

        mostrarMensaje("Producto agregado correctamente.");
        await cargarCarrito();
    } catch (error) {
        mostrarMensaje(error.message);
    }
}

async function cargarCarrito() {
    try {
        const respuesta = await fetch(API_CARRITO);

        if (!respuesta.ok) {
            throw new Error("No se pudo cargar el carrito.");
        }

        const productos = await respuesta.json();
        contenedorCarrito.innerHTML = "";

        let total = 0;

        if (productos.length === 0) {
            contenedorCarrito.textContent = "Tu carrito está vacío.";
        }

        productos.forEach(item => {
            const producto = item.producto;
            const subtotal = Number(producto.precio) * item.cantidad;
            total += subtotal;

            const fila = document.createElement("div");
            fila.className = "item-carrito";

            const informacion = document.createElement("span");
            informacion.textContent =
                producto.nombre + " | Cantidad: " + item.cantidad +
                " | Subtotal: Q" + subtotal.toFixed(2);

            const botonEliminar = document.createElement("button");
            botonEliminar.className = "eliminar";
            botonEliminar.textContent = "Eliminar";
            botonEliminar.addEventListener("click", () => {
                eliminarDelCarrito(item.idShoppingCart);
            });

            fila.append(informacion, botonEliminar);
            contenedorCarrito.appendChild(fila);
        });

        elementoTotal.textContent = "Total: Q" + total.toFixed(2);
    } catch (error) {
        contenedorCarrito.textContent = "Error al cargar el carrito.";
        mostrarMensaje(error.message);
    }
}

async function eliminarDelCarrito(id) {
    try {
        const respuesta = await fetch(API_CARRITO + "/" + id, {
            method: "DELETE"
        });

        if (!respuesta.ok) {
            throw new Error("No se pudo eliminar el producto.");
        }

        mostrarMensaje("Producto eliminado del carrito.");
        await cargarCarrito();
    } catch (error) {
        mostrarMensaje(error.message);
    }
}

cargarProductos();
cargarCarrito();
