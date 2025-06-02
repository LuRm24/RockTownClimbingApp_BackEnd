package org.luciarodriguez.rocktownclimbingapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Representa un horario disponible asociado a una actividad concreta del rocódromo RockTown Climbing.
 *
 * Define el día de la semana y el rango horario (inicio y fin) en el que se imparte la actividad.
 * Está vinculado a la entidad {@link Actividad} mediante una relación muchos-a-uno.
 *
 * Esta clase se utiliza para configurar los horarios semanales de clases, eventos o reservas.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
@Table(name = "horario_disponible")
public class HorarioDisponible {

    /**
     * Identificador único del horario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Día de la semana en el que se imparte la actividad (por ejemplo: LUNES, VIERNES).
     */
    private DayOfWeek diaSemana;

    /**
     * Hora de inicio de la actividad.
     */
    private LocalTime horaInicio;

    /**
     * Hora de fin de la actividad.
     */
    private LocalTime horaFin;

    /**
     * Actividad asociada a este horario.
     * Relación muchos-a-uno con {@link Actividad}.
     */
    @ManyToOne
    @JoinColumn(name = "actividad_id")
    @JsonBackReference
    private Actividad actividad;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayOfWeek getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DayOfWeek diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}
