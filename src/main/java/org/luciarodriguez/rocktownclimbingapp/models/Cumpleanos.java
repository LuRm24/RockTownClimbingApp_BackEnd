package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cumpleanos extends TipoEntrada{
    @Id
    private Long id;
    private boolean comidaIncluida;
    private boolean bebidaIncluida;
    private int maxNinyos;
    private String notasEspecificas;
}
