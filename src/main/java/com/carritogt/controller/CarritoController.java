
package com.carritogt.controller;

import com.carritogt.entity.CarritoItem;
import com.carritogt.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public List<CarritoItem> verCarrito() {
        return carritoService.verCarrito();
    }

    @PostMapping("/agregar")
    public CarritoItem agregarProducto(@RequestBody Map<String, Integer> datos) {
        Integer idProducto = datos.get("idProducto");
        Integer cantidad = datos.get("cantidad");

        return carritoService.agregarProducto(idProducto, cantidad);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> eliminarProducto(@PathVariable Integer id) {
        carritoService.eliminarProducto(id);
        return Map.of("mensaje", "Producto eliminado del carrito");
    }
}

