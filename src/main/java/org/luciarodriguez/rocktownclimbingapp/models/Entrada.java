package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.time.LocalDate;

//Clase Entrada que representa una entrada del cliente al recinto
//para llevar el contador de las sesiones gastadas del bono
@Entity
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @ManyToOne
    private TipoEntrada tipo_entrada;
    @ManyToOne
    private Cliente cliente;

}
