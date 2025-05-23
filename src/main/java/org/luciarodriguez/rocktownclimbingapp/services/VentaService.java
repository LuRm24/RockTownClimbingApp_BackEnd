package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.repositories.VentaRepository;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    private final VentaRepository repo;

    public VentaService(VentaRepository repo) { this.repo = repo; }
}
