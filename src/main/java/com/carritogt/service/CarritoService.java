
package com.carritogt.service;

import com.carritogt.entity.CarritoItem;
import com.carritogt.entity.Producto;
import com.carritogt.repository.CarritoRepository;
import com.carritogt.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    private static final String USUARIO_PRUEBA = "usuario-prueba";

    public CarritoService(
            CarritoRepository carritoRepository,
            ProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    public List<CarritoItem> verCarrito() {
        return carritoRepository.findByCodUsuario(USUARIO_PRUEBA);
    }

    public CarritoItem agregarProducto(Integer idProducto, Integer cantidad) {
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser mayor que cero");
        }

        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() ->
                        new IllegalArgumentException("Producto no encontrado"));

        List<CarritoItem> items = carritoRepository
                .findByCodUsuario(USUARIO_PRUEBA);

        for (CarritoItem item : items) {
            if (item.getProducto().getIdProducto().equals(idProducto)) {
                item.setCantidad(item.getCantidad() + cantidad);
                return carritoRepository.save(item);
            }
        }

        CarritoItem nuevoItem = new CarritoItem();
        nuevoItem.setProducto(producto);
        nuevoItem.setCodUsuario(USUARIO_PRUEBA);
        nuevoItem.setCantidad(cantidad);

        return carritoRepository.save(nuevoItem);
    }

    public void eliminarProducto(Integer idShoppingCart) {
        CarritoItem item = carritoRepository.findById(idShoppingCart)
                .orElseThrow(() ->
                        new IllegalArgumentException("Artículo no encontrado"));

        if (!USUARIO_PRUEBA.equals(item.getCodUsuario())) {
            throw new IllegalArgumentException(
                    "El artículo no pertenece al usuario de prueba");
        }

        carritoRepository.delete(item);
    }
}
