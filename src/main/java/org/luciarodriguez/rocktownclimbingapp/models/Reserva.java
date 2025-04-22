package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Sala sala;

    @ManyToOne
    private Actividad actividad;
}
