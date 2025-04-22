package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.HorarioDisponible;
import org.luciarodriguez.rocktownclimbingapp.services.HorarioDisponibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioDisponibleController {
    @Autowired
    private final HorarioDisponibleService service;
    public HorarioDisponibleController(HorarioDisponibleService service) { this.service = service; }

    @GetMapping
    public List<HorarioDisponible> getAll() { return service.findAll(); }

    @PostMapping
    public HorarioDisponible save(@RequestBody HorarioDisponible h) { return service.save(h); }
}
