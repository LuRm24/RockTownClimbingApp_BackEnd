package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.models.HorarioDisponible;
import org.luciarodriguez.rocktownclimbingapp.services.HorarioDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/horarios")
public class HorarioDisponibleController {
    @Autowired
    private final HorarioDisponibleService service;
    public HorarioDisponibleController(HorarioDisponibleService service) { this.service = service; }

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
}
