package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Entrada;
import org.luciarodriguez.rocktownclimbingapp.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrada")
public class EntradaController {
    @Autowired
    private final EntradaService service;
    public EntradaController(EntradaService service) { this.service = service; }

    @GetMapping
    public List<Entrada> getAll() { return service.findAll(); }

    @PostMapping
    public Entrada save(@RequestBody Entrada e) { return service.save(e); }
}
