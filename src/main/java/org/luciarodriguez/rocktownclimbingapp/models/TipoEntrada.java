package org.luciarodriguez.rocktownclimbingapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tipo_entrada")
public class TipoEntrada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descripcion;
    private String publicoDestino;
    private String frecuencia;
    private double precio;
    private String notas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPublicoDestino() {
        return publicoDestino;
    }

    public void setPublicoDestino(String publicoDestino) {
        this.publicoDestino = publicoDestino;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @OneToMany(mappedBy = "tipo_entrada")
    @JsonBackReference("tipoentrada-cliente")
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "tipo_entrada")
    @JsonBackReference("tipoentrada-venta")
    private List<Venta> ventas = new ArrayList<>();
}
