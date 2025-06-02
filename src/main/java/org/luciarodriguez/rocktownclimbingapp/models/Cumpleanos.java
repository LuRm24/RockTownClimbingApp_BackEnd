package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Representa una entrada de tipo "Cumpleaños", utilizada para eventos especiales organizados en el rocódromo.
 *
 * Esta clase hereda todos los atributos y comportamientos de {@link TipoEntrada}, y puede ser extendida en el futuro
 * para añadir propiedades específicas de este tipo de entrada.
 *
 * Actualmente, define un identificador propio, aunque es recomendable revisar la estrategia de herencia en JPA
 * para evitar conflictos con la clase padre.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
public class Cumpleanos extends TipoEntrada {

    /**
     * Identificador único del tipo de entrada para cumpleaños.
     * Podría solaparse con el ID heredado de {@link TipoEntrada}, por lo que se recomienda revisar la estrategia de herencia.
     */
    @Id
    private Long id;
}
