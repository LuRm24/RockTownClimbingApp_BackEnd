package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.TipoEntrada;
import org.luciarodriguez.rocktownclimbingapp.services.TipoEntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_entrada")
public class TipoEntradaController {

    @Autowired
    private final TipoEntradaService service;

    public TipoEntradaController(TipoEntradaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TipoEntrada> getAll() {
        return service.findAll();
    }

    @PostMapping
    public TipoEntrada save(@RequestBody TipoEntrada tipoEntrada) {
        return service.save(tipoEntrada);
    }
}