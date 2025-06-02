package org.luciarodriguez.rocktownclimbingapp.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una actividad programada en el rocódromo, como puede ser una clase, taller o evento.
 *
 * Cada actividad tiene un nombre, una descripción, un empleado responsable (monitor/instructor)
 * y una lista de horarios disponibles en los que se puede realizar.
 *
 * Esta clase está mapeada como entidad JPA y se relaciona con las entidades {@link Empleado} y {@link HorarioDisponible}.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
public class Actividad {

    /**
     * Identificador único de la actividad.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la actividad (por ejemplo: "Clase de iniciación").
     */
    private String nombre;

    /**
     * Descripción breve de la actividad.
     */
    private String descripcion;

    /**
     * Empleado responsable de impartir o supervisar la actividad.
     */
    @ManyToOne
    private Empleado empleado;

    /**
     * Lista de horarios disponibles en los que se puede realizar esta actividad.
     * Se gestiona en cascada para que los cambios en la actividad afecten también a sus horarios.
     */
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<HorarioDisponible> horarios = new ArrayList<>();

    /**
     * Devuelve el ID de la actividad.
     *
     * @return ID de la actividad
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la actividad.
     *
     * @param id ID a asignar
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de la actividad.
     *
     * @return Nombre de la actividad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la actividad.
     *
     * @param nombre Nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripción de la actividad.
     *
     * @return Descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la actividad.
     *
     * @param descripcion Texto descriptivo de la actividad
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el empleado asignado a esta actividad.
     *
     * @return Empleado responsable
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado responsable de la actividad.
     *
     * @param empleado Empleado a asignar
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Devuelve la lista de horarios disponibles para esta actividad.
     *
     * @return Lista de objetos {@link HorarioDisponible}
     */
    public List<HorarioDisponible> getHorarios() {
        return horarios;
    }

    /**
     * Establece la lista de horarios disponibles para esta actividad.
     *
     * @param horarios Lista de horarios a asignar
     */
    public void setHorarios(List<HorarioDisponible> horarios) {
        this.horarios = horarios;
    }
}
