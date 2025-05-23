package org.luciarodriguez.rocktownclimbingapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RockTownClimbingApp {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("stripe.secret.key", dotenv.get("STRIPE_SECRET_KEY"));
        SpringApplication.run(RockTownClimbingApp.class, args);


    }
}
