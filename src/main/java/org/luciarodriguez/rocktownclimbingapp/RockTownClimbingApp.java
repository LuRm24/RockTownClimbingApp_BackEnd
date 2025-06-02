package org.luciarodriguez.rocktownclimbingapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación RockTownClimbingApp.
 * <p>
 * Esta clase inicializa el contexto de Spring Boot y carga las variables de entorno
 * definidas en el archivo `.env`, necesarias para la configuración de Stripe y de la base de datos.
 * <p>
 * Variables esperadas:
 * <ul>
 *   <li><b>STRIPE_SECRET_KEY</b>: Clave secreta para la API de Stripe</li>
 *   <li><b>DB_URL</b>: URL de conexión a la base de datos</li>
 *   <li><b>DB_USER</b>: Usuario de la base de datos</li>
 *   <li><b>DB_PASS</b>: Contraseña del usuario de base de datos</li>
 * </ul>
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@SpringBootApplication
public class RockTownClimbingApp {

    /**
     * Punto de entrada principal de la aplicación.
     * Carga variables de entorno y lanza la aplicación Spring Boot.
     *
     * @param args argumentos de la línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        // Configuración de Stripe
        System.setProperty("stripe.secret.key", dotenv.get("STRIPE_SECRET_KEY"));

        // Configuración de base de datos
        System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
        System.setProperty("spring.datasource.username", dotenv.get("DB_USER"));
        System.setProperty("spring.datasource.password", dotenv.get("DB_PASS"));

        // Lanzamiento de la aplicación
        SpringApplication.run(RockTownClimbingApp.class, args);
    }
}
