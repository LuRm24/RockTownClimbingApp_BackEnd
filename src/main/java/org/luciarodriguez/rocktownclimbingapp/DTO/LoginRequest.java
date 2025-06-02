package org.luciarodriguez.rocktownclimbingapp.DTO;

/**
 * DTO (Data Transfer Object) utilizado para encapsular los datos de inicio de sesión
 * enviados desde el cliente a la API.
 * <p>
 * Contiene el nombre de usuario y la contraseña introducidos por el empleado en el formulario de login.
 * Se utiliza en el controlador {@code LoginController} para validar las credenciales.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
public class LoginRequest {

    /**
     * Nombre de usuario introducido por el empleado.
     */
    private String nombreUsuario;

    /**
     * Contraseña introducida por el empleado (en texto plano, antes del cifrado).
     */
    private String contrasena;

    /**
     * Devuelve el nombre de usuario introducido.
     *
     * @return Nombre de usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param nombreUsuario Nombre de usuario a asignar
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Devuelve la contraseña introducida.
     *
     * @return Contraseña
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña introducida.
     *
     * @param contrasena Contraseña a asignar
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
