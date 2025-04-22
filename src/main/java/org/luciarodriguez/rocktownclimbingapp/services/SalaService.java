package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Sala;
import org.luciarodriguez.rocktownclimbingapp.repositories.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    private final SalaRepository repo;
    public SalaService(SalaRepository repo) { this.repo = repo; }
    public List<Sala> findAll() { return repo.findAll(); }
    public Sala save(Sala s) { return repo.save(s); }
}
