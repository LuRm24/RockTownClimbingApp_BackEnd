package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Reserva;
import org.luciarodriguez.rocktownclimbingapp.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private final ReservaService service;
    public ReservaController(ReservaService service) { this.service = service; }

    @GetMapping
    public List<Reserva> getAll() { return service.findAll(); }

    @PostMapping
    public Reserva save(@RequestBody Reserva r) { return service.save(r); }
}
