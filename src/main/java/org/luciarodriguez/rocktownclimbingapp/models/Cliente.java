package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private boolean menorEdad;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Entrada> entradas = new ArrayList<>();


}
