package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Producto;
import org.luciarodriguez.rocktownclimbingapp.repositories.ProductoRepository;
import org.luciarodriguez.rocktownclimbingapp.repositories.TipoEntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) { this.repo = repo; }

    public List<Producto> findAll() {
        return repo.findAll();
    }
}
