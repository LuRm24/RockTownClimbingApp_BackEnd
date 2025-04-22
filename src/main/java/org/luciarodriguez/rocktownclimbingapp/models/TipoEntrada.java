package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_entrada")
public class TipoEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descripcion;
    private String publicoDestino;
    private String frecuencia;
    private double precio;
    private String notas;

    @OneToMany(mappedBy = "tipo_entrada")
    private List<Entrada> entradas = new ArrayList<>();
}
