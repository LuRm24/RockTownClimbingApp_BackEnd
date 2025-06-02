package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de actividades en la aplicación RockTown Climbing.
 * <p>
 * Expone endpoints para realizar operaciones CRUD básicas sobre entidades de tipo {@link Actividad},
 * tales como listar todas las actividades, insertar nuevas, buscar por ID y eliminar.
 * <p>
 * Este controlador delega la lógica de negocio en el servicio {@link ActividadService}.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    private final ActividadService service;

    public ActividadController(ActividadService service) {
        this.service = service;
    }

    /**
     * Obtiene una lista de todas las actividades registradas.
     *
     * @return Lista de actividades
     */
    @GetMapping("/select-all")
    public List<Actividad> getAll() {
        return service.findAll();
    }

    /**
     * Inserta una nueva actividad en la base de datos.
     *
     * @param a Objeto {@link Actividad} recibido en el cuerpo de la petición
     * @return Actividad guardada
     */
    @PostMapping("/insert")
    public Actividad save(@RequestBody Actividad a) {
        return service.save(a);
    }

    /**
     * Elimina una actividad por su identificador.
     *
     * @param id ID de la actividad a eliminar
     * @return {@code 200 OK} si se eliminó correctamente, o {@code 404 Not Found} si no se encontró la actividad
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarActividad(@PathVariable Long id) {
        Optional<Actividad> actividad = service.findById(id);
        if (actividad.isPresent()) {
            service.borrarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Busca una actividad por su ID.
     *
     * @param id Identificador de la actividad a buscar
     * @return Objeto {@link Actividad} si existe, o {@code 404 Not Found} si no se encuentra
     */
    @GetMapping("/find")
    public ResponseEntity<Actividad> findById(@RequestParam Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
