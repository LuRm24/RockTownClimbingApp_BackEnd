package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.TipoEntrada;
import org.luciarodriguez.rocktownclimbingapp.repositories.TipoEntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEntradaService {
    private final TipoEntradaRepository repo;
    public TipoEntradaService(TipoEntradaRepository repo) { this.repo = repo; }
    public List<TipoEntrada> findAll() { return repo.findAll(); }
    public TipoEntrada save(TipoEntrada a) { return repo.save(a); }
}
