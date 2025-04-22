package org.luciarodriguez.rocktownclimbingapp.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioController {
    @GetMapping("/")
        public String inicio() {
            return "Hola desde el backend";
        }
    }

