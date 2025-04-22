package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Sala;
import org.luciarodriguez.rocktownclimbingapp.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {
    @Autowired
    private final SalaService service;
    public SalaController(SalaService service) { this.service = service; }

    @GetMapping
    public List<Sala> getAll() { return service.findAll(); }

    @PostMapping
    public Sala save(@RequestBody Sala s) { return service.save(s); }
}
