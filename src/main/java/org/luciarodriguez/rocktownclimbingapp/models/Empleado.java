package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un empleado del rocódromo RockTown Climbing.
 * <p>
 * Cada empleado puede tener asignadas múltiples actividades y recordatorios.
 * La clase incluye información personal, credenciales de acceso y rol dentro del sistema.
 * <p>
 * Está mapeada como entidad JPA y se persiste en la base de datos.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

    /**
     * Identificador único del empleado. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del empleado.
     */
    private String nombre;

    /**
     * Apellidos del empleado.
     */
    private String apellidos;

    /**
     * Rol del empleado en la aplicación (por ejemplo: administrador, recepcionista, monitor).
     */
    private String rol;

    /**
     * Documento Nacional de Identidad del empleado.
     */
    private String dni;

    /**
     * Dirección postal del empleado.
     */
    private String direccion;

    /**
     * Nombre de usuario utilizado para iniciar sesión en el sistema.
     */
    private String nombreUsuario;

    /**
     * Correo electrónico del empleado.
     */
    private String email;

    /**
     * Contraseña encriptada del empleado, almacenada como hash con BCrypt.
     */
    private String contrasenaHash;

    /**
     * Número de teléfono del empleado.
     */
    private String telefono;

    /**
     * Lista de actividades asignadas a este empleado.
     * Relación uno-a-muchos con la entidad {@link Actividad}.
     */
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REMOVE)
    private List<Actividad> actividades = new ArrayList<>();

    /**
     * Lista de recordatorios asignados a este empleado.
     * Relación uno-a-muchos con la entidad {@link Recordatorio}.
     */
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.REMOVE)
    private List<Recordatorio> recordatorios = new ArrayList<>();

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
