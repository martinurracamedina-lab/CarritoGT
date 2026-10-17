package com.carritogt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {

    @GetMapping("/api/inicio")
    public String inicio() {
        return "CarritoGT API funcionando correctamente";
    }
}
