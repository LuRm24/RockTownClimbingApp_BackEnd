package org.luciarodriguez.rocktownclimbingapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String dni;
    private LocalDate fechaBono;
    private int sesionesGastadas;
    private boolean pieGato;
    private int edad;

    @ManyToOne
    private TipoEntrada tipo_entrada;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Venta> ventas = new ArrayList<>();
}
