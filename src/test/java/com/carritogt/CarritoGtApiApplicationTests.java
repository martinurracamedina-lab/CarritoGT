
package com.carritogt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CarritoGtApiApplicationTests {

    @LocalServerPort
    private int puerto;

    @Test
    void contextLoads() {
        // Comprueba que la aplicación pueda iniciar.
    }

    @Test
    void debeConsultarProductos() throws Exception {
        String url = "http://localhost:" + puerto + "/api/productos";

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> respuesta = cliente.send(
                solicitud,
                HttpResponse.BodyHandlers.ofString()
        );

        assertEquals(200, respuesta.statusCode());
        assertNotNull(respuesta.body());
    }
}

