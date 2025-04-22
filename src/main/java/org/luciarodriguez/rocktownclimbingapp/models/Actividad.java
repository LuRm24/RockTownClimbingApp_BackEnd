package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @ManyToOne
    private Empleado empleado;

    @OneToMany(mappedBy = "actividad")
    private List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "actividad")
    private List<HorarioDisponible> horarios = new ArrayList<>();
}
