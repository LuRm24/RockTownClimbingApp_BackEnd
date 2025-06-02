package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.models.HorarioDisponible;
import org.luciarodriguez.rocktownclimbingapp.services.ActividadService;
import org.luciarodriguez.rocktownclimbingapp.services.HorarioDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de horarios disponibles en la aplicación RockTown Climbing.
 * <p>
 * Permite consultar, crear, eliminar y asignar actividades a horarios específicos.
 * Este controlador trabaja conjuntamente con {@link HorarioDisponibleService} y {@link ActividadService}
 * para delegar la lógica de negocio.
 * <p>
 * Los horarios representan franjas asociables a actividades dentro del sistema de planificación.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
@RequestMapping("/horarios")
public class HorarioDisponibleController {

    /**
     * Servicio que gestiona la lógica relacionada con los horarios disponibles.
     */
    @Autowired
    private final HorarioDisponibleService service;

    /**
     * Servicio de actividades utilizado para vincular actividades a horarios.
     */
    @Autowired
    private final ActividadService actividadService;

    /**
     * Constructor del controlador con inyección de los servicios necesarios.
     *
     * @param service          Servicio de horarios disponibles
     * @param actividadService Servicio de actividades
     */
    public HorarioDisponibleController(HorarioDisponibleService service, ActividadService actividadService) {
        this.service = service;
        this.actividadService = actividadService;
    }

    /**
     * Obtiene todos los horarios disponibles registrados en el sistema.
     *
     * @return Lista de objetos {@link HorarioDisponible}
     */
    @GetMapping
    public List<HorarioDisponible> getAll() {
        return service.findAll();
    }

    /**
     * Crea un nuevo horario disponible en la base de datos.
     *
     * @param h Objeto {@link HorarioDisponible} recibido en el cuerpo de la solicitud
     * @return Horario guardado
     */
    @PostMapping("/insert")
    public HorarioDisponible save(@RequestBody HorarioDisponible h) {
        return service.save(h);
    }

    /**
     * Elimina un horario disponible por su ID.
     *
     * @param id ID del horario a eliminar
     * @return {@code 200 OK} si fue eliminado, o {@code 404 Not Found} si no se encontró
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarActividad(@PathVariable Long id) {
        Optional<HorarioDisponible> actividad = service.findById(id);
        if (actividad.isPresent()) {
            service.borrarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Asigna una actividad específica a un horario existente.
     *
     * @param horarioId   ID del horario a actualizar
     * @param actividadId ID de la actividad que se va a asignar
     * @return Horario actualizado con la actividad asignada, o {@code 404 Not Found} si no se encuentra el horario,
     * o {@code 400 Bad Request} si la actividad no es válida
     */
    @PutMapping("/{horarioId}/actividad/{actividadId}")
    public ResponseEntity<HorarioDisponible> actualizarActividadHorario(
            @PathVariable Long horarioId,
            @PathVariable Long actividadId) {

        Optional<HorarioDisponible> horarioOpt = service.findById(horarioId);
        Optional<Actividad> actividadOpt = actividadService.findById(actividadId);

        if (!horarioOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        if (!actividadOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        HorarioDisponible horario = horarioOpt.get();
        horario.setActividad(actividadOpt.get());
        service.save(horario);

        return ResponseEntity.ok(horario);
    }
}
