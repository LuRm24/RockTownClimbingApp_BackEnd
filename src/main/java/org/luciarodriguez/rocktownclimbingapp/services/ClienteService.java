package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repo;
    public ClienteService(ClienteRepository repo) {
        this.repo = repo; }
    public List<Cliente> findAll() {
        return repo.findAll(); }
    public Optional<Cliente> findById(Long id) {
        return repo.findById(id); }
    public Cliente save(Cliente c) {
        return repo.save(c); }
}
