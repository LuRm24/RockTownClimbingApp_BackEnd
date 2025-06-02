package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Recordatorio;
import org.luciarodriguez.rocktownclimbingapp.services.RecordatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de recordatorios en la aplicación RockTown Climbing.
 * <p>
 * Este controlador permite consultar, crear y eliminar recordatorios asociados a empleados.
 * Los recordatorios pueden utilizarse para anotar tareas, notas u otras acciones pendientes dentro de la aplicación.
 * <p>
 * La lógica de negocio se delega en el servicio {@link RecordatorioService}.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
@RequestMapping("/recordatorio")
public class RecordatorioController {

    /**
     * Servicio encargado de gestionar las operaciones sobre recordatorios.
     */
    @Autowired
    private final RecordatorioService service;

    /**
     * Constructor del controlador con inyección del servicio.
     *
     * @param service Servicio de recordatorios
     */
    public RecordatorioController(RecordatorioService service) {
        this.service = service;
    }

    /**
     * Devuelve todos los recordatorios existentes en la base de datos.
     *
     * @return Lista de objetos {@link Recordatorio}
     */
    @GetMapping
    public List<Recordatorio> getAll() {
        return service.findAll();
    }

    /**
     * Devuelve todos los recordatorios asociados a un empleado específico.
     *
     * @param empleadoId ID del empleado del cual se quieren recuperar los recordatorios
     * @return Lista de recordatorios pertenecientes al empleado
     */
    @GetMapping("/find-by-emp")
    public List<Recordatorio> findRecordatorioByEmpleado(@RequestParam Long empleadoId) {
        return service.findRecordatorioByEmpleado(empleadoId);
    }

    /**
     * Guarda un nuevo recordatorio en la base de datos.
     *
     * @param recordatorio Objeto {@link Recordatorio} recibido en el cuerpo de la solicitud
     * @return Recordatorio guardado
     */
    @PostMapping("/insert")
    public Recordatorio save(@RequestBody Recordatorio recordatorio) {
        return service.save(recordatorio);
    }

    /**
     * Elimina todos los recordatorios de la base de datos.
     *
     * @return Respuesta sin contenido ({@code 204 No Content})
     */
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete() {
        service.removeAll();
        return ResponseEntity.noContent().build();
    }

    /**
     * Elimina un recordatorio específico por su ID.
     *
     * @param id ID del recordatorio a eliminar
     * @return {@code 200 OK} si se elimina correctamente, {@code 404 Not Found} si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarRecordatorio(@PathVariable Long id) {
        Optional<Recordatorio> recordatorio = service.findById(id);
        if (recordatorio.isPresent()) {
            service.borrarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
