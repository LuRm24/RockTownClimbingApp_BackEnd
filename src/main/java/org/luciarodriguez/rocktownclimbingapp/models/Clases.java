package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Clases extends TipoEntrada{
    @Id
    private Long id;
}
