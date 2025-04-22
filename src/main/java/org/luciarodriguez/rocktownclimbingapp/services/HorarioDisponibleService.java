package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.HorarioDisponible;
import org.luciarodriguez.rocktownclimbingapp.repositories.HorarioDisponibleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioDisponibleService {
    private final HorarioDisponibleRepository repo;
    public HorarioDisponibleService(HorarioDisponibleRepository repo) { this.repo = repo; }
    public List<HorarioDisponible> findAll() { return repo.findAll(); }
    public HorarioDisponible save(HorarioDisponible h) { return repo.save(h); }
}
