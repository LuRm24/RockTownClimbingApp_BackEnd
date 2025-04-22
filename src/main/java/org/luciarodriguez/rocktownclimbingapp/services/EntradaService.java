package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Entrada;
import org.luciarodriguez.rocktownclimbingapp.repositories.EntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {
    private final EntradaRepository repo;
    public EntradaService(EntradaRepository repo) { this.repo = repo; }
    public List<Entrada> findAll() { return repo.findAll(); }
    public Entrada save(Entrada e) { return repo.save(e); }
}
