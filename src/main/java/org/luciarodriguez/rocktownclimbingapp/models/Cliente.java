package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Representa un cliente registrado en el rocódromo RockTown Climbing.
 *
 * Contiene información personal básica, así como detalles de su tipo de entrada,
 * si alquila pies de gato, y la fecha de activación del bono.
 *
 * Esta clase se encuentra mapeada como entidad JPA y se persiste en la base de datos.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class Cliente {

    /**
     * Identificador único del cliente. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Apellidos del cliente.
     */
    private String apellidos;

    /**
     * Número de teléfono del cliente.
     */
    private String telefono;

    /**
     * DNI del cliente. Se utiliza como campo de búsqueda adicional.
     */
    private String dni;

    /**
     * Fecha en la que se activó el bono del cliente.
     */
    private LocalDate fechaBono;

    /**
     * Indica si el cliente alquila pies de gato.
     */
    private boolean pieGato;

    /**
     * Edad del cliente.
     */
    private int edad;

    /**
     * Tipo de entrada o bono asignado al cliente.
     * Relación muchos-a-uno con {@link TipoEntrada}.
     */
    @ManyToOne
    private TipoEntrada tipo_entrada;

    // Getters y setters explícitos incluidos por compatibilidad con frameworks y bibliotecas
}
