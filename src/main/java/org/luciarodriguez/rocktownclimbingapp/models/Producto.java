package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa un producto disponible en el sistema del rocódromo RockTown Climbing.
 *
 * Los productos pueden ser bebidas, snacks, material deportivo u otros artículos
 * que se vendan en recepción o se ofrezcan a los clientes.
 *
 * Cada producto tiene un nombre identificativo y un precio asociado.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Getter
@Setter
@Entity
public class Producto {

    /**
     * Identificador único del producto. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto (por ejemplo: agua, magnesio, camiseta).
     */
    private String nombre;

    /**
     * Precio en euros del producto.
     */
    private double precio;

    // Métodos getter y setter definidos manualmente para compatibilidad total

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
