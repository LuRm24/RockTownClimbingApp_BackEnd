package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.TipoEntrada;
import org.luciarodriguez.rocktownclimbingapp.services.TipoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de tipos de entrada en la aplicación RockTown Climbing.
 * <p>
 * Los tipos de entrada representan diferentes bonos o modalidades de acceso que puede adquirir un cliente,
 * como entradas sueltas, bonos mensuales, entradas para menores, etc.
 * <p>
 * Este controlador permite consultar todos los tipos de entrada y registrar nuevos en la base de datos.
 * <p>
 * La lógica de negocio se delega en el servicio {@link TipoEntradaService}.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
@RequestMapping("/tipo_entrada")
public class TipoEntradaController {

    /**
     * Servicio encargado de gestionar los tipos de entrada.
     */
    @Autowired
    private final TipoEntradaService service;

    /**
     * Constructor del controlador con inyección del servicio correspondiente.
     *
     * @param service Servicio de tipos de entrada a inyectar
     */
    public TipoEntradaController(TipoEntradaService service) {
        this.service = service;
    }

    /**
     * Devuelve todos los tipos de entrada existentes en la base de datos.
     *
     * @return Lista de objetos {@link TipoEntrada}
     */
    @GetMapping("/select-all")
    public List<TipoEntrada> getAll() {
        return service.findAll();
    }

    /**
     * Guarda un nuevo tipo de entrada en la base de datos.
     *
     * @param tipoEntrada Objeto {@link TipoEntrada} recibido en el cuerpo de la solicitud
     * @return El tipo de entrada guardado
     */
    @PostMapping
    public TipoEntrada save(@RequestBody TipoEntrada tipoEntrada) {
        return service.save(tipoEntrada);
    }
}
