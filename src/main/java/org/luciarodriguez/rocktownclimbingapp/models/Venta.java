package org.luciarodriguez.rocktownclimbingapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;


    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private TipoEntrada tipo_entrada;
    private int cantidad;
    private double total;
    private String formaPago;
}
