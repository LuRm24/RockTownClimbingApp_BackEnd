package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    private final ActividadService service;
    public ActividadController(ActividadService service) { this.service = service; }

    @GetMapping
    public List<Actividad> getAll() { return service.findAll(); }

    @PostMapping("/insert")
    public Actividad save(@RequestBody Actividad a) { return service.save(a); }
}
