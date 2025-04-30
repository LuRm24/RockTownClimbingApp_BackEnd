package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.ClienteRepository;
import org.luciarodriguez.rocktownclimbingapp.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private final ClienteService service;
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping("/select-all")
    public List<Cliente> getAll() { return service.findAll(); }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return service.save(cliente); }

    @PostMapping("/insert")
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
        Cliente guardado = clienteRepository.save(cliente);
        return ResponseEntity.ok(guardado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = service.findById(id);
        if (cliente.isPresent()) {
            service.borrarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/find")
    public ResponseEntity<Cliente> findById(@RequestParam Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/find-client")
    public List<Cliente> findByDniOrApellidosOrTelefono(
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String telefono) {

        return service.findMultiple(dni, apellidos, telefono);
    }

    @PutMapping("/update")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente clienteActualizado) {
        Cliente actualizado = service.updateCliente(clienteActualizado);
        return ResponseEntity.ok(actualizado);
    }

}
