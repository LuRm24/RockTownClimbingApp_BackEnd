package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Representa una entrada de tipo "Clases", utilizada para sesiones formativas o cursos en el rocódromo.
 *
 * Esta clase extiende de {@link TipoEntrada}, heredando sus atributos comunes, y permite diferenciar este tipo de entrada
 * del resto en la lógica del sistema.
 *
 * Actualmente incluye un identificador propio, aunque se recomienda revisar la estrategia de herencia
 * si el campo {@code id} ya existe en la superclase.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
public class Clases extends TipoEntrada {

    /**
     * Identificador único del tipo de entrada para clases.
     * Se debe verificar que no entre en conflicto con el identificador heredado de {@link TipoEntrada}.
     */
    @Id
    private Long id;
}
