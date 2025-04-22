package org.luciarodriguez.rocktownclimbingapp.conexion;

import org.luciarodriguez.rocktownclimbingapp.DTO.LoginRequest;
import org.luciarodriguez.rocktownclimbingapp.controllers.LoginController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public void arrancarServidor() {

        try {
            //Conectamos servidor al puerto
            ServerSocket serverSocket = new ServerSocket(49300);

            while (true) {
                //Creamos el socket para la conexión con cliente
                Socket socket = new Socket();

                System.out.println("Esperando conexiones del cliente");

                //Llamamos al metodo accept del socket que acepta la conexión de un cliente
                //y queda a la espera hasta que el cliente se conecta
                socket = serverSocket.accept();

                //Recibe del cliente el nombre nada mas conectarse
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String usuario = entrada.readLine();
                String contrasena = entrada.readLine();

                //Indicamos que se ha recibido el nombre y se ha conectado el ciente
                System.out.println("Cliente conectado: " + usuario + " - " + contrasena);

                // Crear un objeto RestTemplate
                RestTemplate restTemplate = new RestTemplate();

                // URL del endpoint de login
                String url = "http://localhost:8080/login";  // Asegúrate de que la URL sea correcta

                // Crear el objeto LoginRequest
                LoginRequest loginRequest = new LoginRequest();
                loginRequest.setNombreUsuario(usuario);
                loginRequest.setContrasena(contrasena);

                // Encabezados HTTP (si necesitas configurarlos)
                HttpHeaders headers = new HttpHeaders();
                headers.set("Content-Type", "application/json");

                // Crear la solicitud HTTP con el cuerpo y encabezados
                HttpEntity<LoginRequest> entity = new HttpEntity<>(loginRequest, headers);

                // Realizar la solicitud POST y obtener la respuesta
                ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

                // Imprimir la respuesta
                String respuesta = response.getBody();
                System.out.println("Respuesta del servidor: " + respuesta);

                //Enviarle la instrucción al servidor
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
                salida.println(respuesta);
            }
        }
        catch (IOException io){
            io.printStackTrace();
        }
    }
}
