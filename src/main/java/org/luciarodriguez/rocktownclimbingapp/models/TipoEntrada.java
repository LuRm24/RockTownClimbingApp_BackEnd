package org.luciarodriguez.rocktownclimbingapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un tipo de entrada disponible en el rocódromo, como bonos, clases o cumpleaños.
 *
 * Cada tipo de entrada incluye información sobre su precio, público destinatario,
 * frecuencia de uso y si incluye servicios adicionales como comida o bebida.
 *
 * Esta entidad se relaciona con la clase {@link Cliente}, ya que un mismo tipo de entrada
 * puede ser asignado a varios clientes.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
@Getter
@Setter
@Table(name = "tipo_entrada")
public class TipoEntrada {

    /**
     * Identificador único del tipo de entrada.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del tipo de entrada (por ejemplo: Bono 10 sesiones, Clase suelta, Cumpleaños).
     */
    private String tipo;

    /**
     * Descripción general de lo que incluye este tipo de entrada.
     */
    private String descripcion;

    /**
     * Público al que va destinado este tipo de entrada (por ejemplo: Infantil, Adultos, Todos los públicos).
     */
    private String publico_destino;

    /**
     * Frecuencia de uso del tipo de entrada (por ejemplo: diario, semanal, puntual).
     */
    private String frecuencia;

    /**
     * Precio del tipo de entrada.
     */
    private double precio;

    /**
     * Indica si la entrada incluye una bebida.
     */
    private boolean bebida_incluida;

    /**
     * Indica si la entrada incluye comida.
     */
    private boolean comida_incluida;

    /**
     * Notas adicionales o aclaraciones sobre esta entrada.
     */
    private String notas;

    /**
     * Lista de clientes que han adquirido o utilizan este tipo de entrada.
     * Relación uno-a-muchos con {@link Cliente}.
     */
    @OneToMany(mappedBy = "tipo_entrada")
    @JsonBackReference("tipoentrada-cliente")
    private List<Cliente> clientes = new ArrayList<>();


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
        return publico_destino;
    }

    public void setPublicoDestino(String publicoDestino) {
        this.publico_destino = publicoDestino;
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

    public boolean isBebidaIncluida() {
        return bebida_incluida;
    }

    public void setBebidaIncluida(boolean bebidaIncluida) {
        this.bebida_incluida = bebidaIncluida;
    }

    public boolean isComidaIncluida() {
        return comida_incluida;
    }

    public void setComidaIncluida(boolean comidaIncluida) {
        this.comida_incluida = comidaIncluida;
    }
}
