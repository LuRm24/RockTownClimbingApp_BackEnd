package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Cumpleanos;
import org.luciarodriguez.rocktownclimbingapp.repositories.CumpleanosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CumpleanosService {
    private final CumpleanosRepository repo;
    public CumpleanosService(CumpleanosRepository repo) { this.repo = repo; }
    public List<Cumpleanos> findAll() { return repo.findAll(); }
    public Cumpleanos save(Cumpleanos a) { return repo.save(a); }
}
