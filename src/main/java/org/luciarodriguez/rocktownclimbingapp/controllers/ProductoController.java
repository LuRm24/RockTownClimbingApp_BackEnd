package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Producto;
import org.luciarodriguez.rocktownclimbingapp.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para la gestión de productos en la aplicación RockTown Climbing.
 * <p>
 * Este controlador permite obtener la lista completa de productos registrados en el sistema,
 * como parte de la funcionalidad de la caja o inventario.
 * <p>
 * La lógica de negocio se delega en el servicio {@link ProductoService}.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
@RequestMapping("/producto")
public class ProductoController {

    /**
     * Servicio encargado de la lógica relacionada con productos.
     */
    @Autowired
    private final ProductoService service;

    /**
     * Constructor del controlador que permite la inyección del servicio.
     *
     * @param service Servicio de productos a inyectar
     */
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    /**
     * Devuelve la lista de todos los productos disponibles en la base de datos.
     *
     * @return Lista de objetos {@link Producto}
     */
    @GetMapping("/select-all")
    public List<Producto> getAllProductos() {
        return service.findAll();
    }
}
