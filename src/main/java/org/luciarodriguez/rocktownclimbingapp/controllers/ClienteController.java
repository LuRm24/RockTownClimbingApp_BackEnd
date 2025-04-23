package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private final ClienteService service;
    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public List<Cliente> getAll() { return service.findAll(); }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return service.save(cliente); }
}
