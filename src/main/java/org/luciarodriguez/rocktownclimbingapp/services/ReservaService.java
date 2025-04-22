package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Reserva;
import org.luciarodriguez.rocktownclimbingapp.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    private final ReservaRepository repo;
    public ReservaService(ReservaRepository repo) { this.repo = repo; }
    public List<Reserva> findAll() { return repo.findAll(); }
    public Reserva save(Reserva r) { return repo.save(r); }
}
