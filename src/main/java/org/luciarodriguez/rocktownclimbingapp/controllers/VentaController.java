package org.luciarodriguez.rocktownclimbingapp.controllers;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.luciarodriguez.rocktownclimbingapp.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private final VentaService service;

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @PostMapping("/registrar-pago-efectivo")
    public ResponseEntity<?> registrarPagoEfectivo(@RequestParam double cantidad) {
        try {
            Stripe.apiKey = stripeSecretKey;

            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount((long)(cantidad * 100)) // céntimos
                    .setCurrency("eur")
                    .putMetadata("metodo_pago", "efectivo")
                    .putMetadata("descripcion", "Pago en efectivo desde app")
                    .build();

            PaymentIntent intent = PaymentIntent.create(params);

            return ResponseEntity.ok("Pago en efectivo registrado en Stripe con ID: " + intent.getId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
