package org.luciarodriguez.rocktownclimbingapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    @JsonBackReference("tipoentrada-cliente")
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "tipo_entrada")
    @JsonBackReference("tipoentrada-venta")
    private List<Venta> ventas = new ArrayList<>();
}
