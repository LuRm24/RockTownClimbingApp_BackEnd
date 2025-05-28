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

@RestController
@RequestMapping("/horarios")
public class HorarioDisponibleController {
    @Autowired
    private final HorarioDisponibleService service;
    @Autowired
    private final ActividadService actividadService;
    public HorarioDisponibleController(HorarioDisponibleService service, ActividadService actividadService) {
        this.service = service;
        this.actividadService = actividadService;
    }

    @GetMapping
    public List<HorarioDisponible> getAll() { return service.findAll(); }

    @PostMapping("/insert")
    public HorarioDisponible save(@RequestBody HorarioDisponible h) { return service.save(h); }

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
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // o un error personalizado "Actividad no encontrada"
        }

        HorarioDisponible horario = horarioOpt.get();
        horario.setActividad(actividadOpt.get());
        service.save(horario);

        return ResponseEntity.ok(horario);
    }
}
