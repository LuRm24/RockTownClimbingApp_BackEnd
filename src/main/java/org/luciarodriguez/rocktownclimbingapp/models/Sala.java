package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "sala")
    private List<HorarioDisponible> horarios = new ArrayList<>();

    @OneToMany(mappedBy = "sala")
    private List<Reserva> reservas = new ArrayList<>();
}
