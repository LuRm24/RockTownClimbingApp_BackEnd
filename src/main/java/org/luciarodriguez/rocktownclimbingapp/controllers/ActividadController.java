package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    private final ActividadService service;
    public ActividadController(ActividadService service) { this.service = service; }

    @GetMapping("/select-all")
    public List<Actividad> getAll() { return service.findAll(); }

    @PostMapping("/insert")
    public Actividad save(@RequestBody Actividad a) {
        return service.save(a);
    }

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

    @GetMapping("/find")
    public ResponseEntity<Actividad> findById(@RequestParam Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
