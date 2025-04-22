package org.luciarodriguez.rocktownclimbingapp;

import org.luciarodriguez.rocktownclimbingapp.conexion.Servidor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RockTownClimbingApp {
    public static void main(String[] args) {
        SpringApplication.run(RockTownClimbingApp.class, args);

        //Iniciamos servidor
        Servidor servidor = new Servidor();
        servidor.arrancarServidor();
    }
}
