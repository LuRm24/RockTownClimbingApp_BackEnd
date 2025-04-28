package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Recordatorio;
import org.luciarodriguez.rocktownclimbingapp.services.RecordatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recordatorio")
public class RecordatorioController {
    @Autowired
    private final RecordatorioService service;

    public RecordatorioController(RecordatorioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Recordatorio> getAll() {
        return service.findAll();
    }

    @GetMapping("/find-by-emp")
    public List<Recordatorio> findRecordatorioByEmpleado(@RequestParam Long empleadoId) {
        return service.findRecordatorioByEmpleado(empleadoId);
    }

    @PostMapping("/insert")
    public Recordatorio save(@RequestBody Recordatorio recordatorio) {
        return service.save(recordatorio);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete() {
        service.removeAll();
        return ResponseEntity.noContent().build(); // Devuelve HTTP 204
    }
}
