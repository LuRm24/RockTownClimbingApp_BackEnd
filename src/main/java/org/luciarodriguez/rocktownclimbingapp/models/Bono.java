package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Representa un tipo especial de entrada denominada "Bono", que hereda todas las propiedades de {@link TipoEntrada}.
 *
 * Esta clase puede ser utilizada para diferenciar lógicamente un bono del resto de entradas, por ejemplo
 * en lógica de negocio o filtrados, aunque actualmente no añade atributos adicionales.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
public class Bono extends TipoEntrada {

    /**
     * Identificador único del bono. Aunque hereda de {@link TipoEntrada}, define su propio ID.
     */
    @Id
    private Long id;
}
