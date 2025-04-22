package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.repositories.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {
    private final ActividadRepository repo;
    public ActividadService(ActividadRepository repo) { this.repo = repo; }
    public List<Actividad> findAll() { return repo.findAll(); }
    public Actividad save(Actividad a) { return repo.save(a); }
}
