package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Cumpleanos;
import org.luciarodriguez.rocktownclimbingapp.services.CumpleanosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cumpleanos")
public class CumpleanosController {
    @Autowired
    private final CumpleanosService service;
    public CumpleanosController(CumpleanosService service) { this.service = service; }

    @GetMapping
    public List<Cumpleanos> getAll() { return service.findAll(); }

    @PostMapping
    public Cumpleanos save(@RequestBody Cumpleanos cumpleanos) {
        return service.save(cumpleanos); }
}
