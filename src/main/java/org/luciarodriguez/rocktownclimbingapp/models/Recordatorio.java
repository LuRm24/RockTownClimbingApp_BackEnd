package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

/**
 * Representa un recordatorio asociado a un empleado del sistema RockTown Climbing.
 *
 * Los recordatorios permiten dejar notas o tareas pendientes vinculadas a un empleado específico.
 * Esta entidad se puede utilizar, por ejemplo, para gestionar tareas administrativas o avisos personales.
 *
 * Está mapeada como una entidad JPA y vinculada mediante una relación muchos-a-uno con {@link Empleado}.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
public class Recordatorio {

    /**
     * Identificador único del recordatorio.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Texto del recordatorio. Puede contener cualquier nota o instrucción.
     */
    private String texto;

    /**
     * Empleado al que está asignado este recordatorio.
     * Relación muchos-a-uno con {@link Empleado}.
     */
    @ManyToOne
    private Empleado empleado;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
